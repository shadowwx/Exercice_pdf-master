package org.epsi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.epsi.entity.Client;
import org.epsi.entity.DetailsRequests;
import org.epsi.entity.Request;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter; 

import org.epsi.service.ClientService;
import org.epsi.service.RequestService;


@Controller
public class PdfController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome() {
        return "menu";
    }

	@Autowired
    private ClientService clientService;
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value = "/downloadPDF/{clientId}", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable(value="clientId") final Long clientId, ModelMap pModel) {
    	  	
    	//recuperation client
    	Client lClient = clientService.getClient(clientId);
    	if (lClient != null) {
    		//traitement
    		//recuperation factures du client 
        	ArrayList<Request> lRequest = new ArrayList<Request>();
        	
        	for(Request r : lClient.getFactures()) {
        		lRequest.add(r);
        	}
        	
        	pModel.addAttribute("lRequest", lRequest);
        	pModel.addAttribute("lClient", lClient);
    	} else {
    		// traitement erreur
    		//TODO
        	System.out.println("Error client null");
    	}  		
    	
    	//A voir plus tard
        return new ModelAndView("listRequest");
    }
	
	@RequestMapping(value = "/Facture-Pdf", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF(@RequestParam(value="request_billNumber") Long billing) {
				
	    Request request = requestService.getRequest(billing);
	    
		
	    // Here you have to set the actual filename of your pdf
	    String filename = "FactureClient-"+request.getClient().getClient_id()+".pdf";
	    File myFile = new File(filename);
	    FileOutputStream fos;
	    byte[] out = new byte[]{};
	    //Création du document
	    Document document = new Document();
	    //Récupération du DetailsRequest
	    
	    
	    
		try {
			fos = new FileOutputStream(myFile);		

			//Appel à la méthode d'écriture dans le PDF
		    writeInPdf(document, fos, request);
		    out = Files.readAllBytes(myFile.toPath());
		
		} catch (IOException|DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    return new ResponseEntity<>(out, headers, HttpStatus.OK);
	}
	
		
	private void writeInPdf(Document document, FileOutputStream fos, Request request) throws DocumentException, MalformedURLException, IOException {
		PdfWriter.getInstance(document, fos);
	    document.open();
	    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	    Client client = request.getClient();
	    
	    //addPdfHeader(document,client); Pour Partitionner le contenue
	    document.add(new Paragraph("Nom : " + client.getName(), font));
	    document.add(new Paragraph("Prénom : " + client.getFirstName(), font));
	    
	    //Image à placer
	    URL url = getClass().getClassLoader().getResource("testImage.png");
		if(null != url) {		
		    System.out.println(url.toString());
		    Image img = Image.getInstance(url);
		    img.scaleToFit(100, 100);;
		    document.add(img);
		} else {
			System.out.println("url is null");
		}
	    
	    document.add(new Paragraph("Date de Commande : " + request.getDateCreation(), font));

	    
	    document.add( Chunk.NEWLINE );
	    
	    
	    
	    PdfPTable table = new PdfPTable(4);
	    addTableHeader(table);
	    
	    
	    for(DetailsRequests dr : request.getDetailsRequests()) {    	
	    	
	    	addRow(table, dr);
	    }
	    
	    document.add(table);
	    
	    //request.getTotalTTC
	    
	    //Mise en place de la méthode en cas de condition null
	    document.add(new Paragraph("Lieu de livraison : " + request.renderDeliveryPlace(), font));
	    
	    //Mise en place d'une condition ternaire en cas de condition null
	    document.add(new Paragraph("Date de livraison : " + (request.getDateDelivery() !=null ? request.getDateDelivery() : "Aucune"), font));
	    
	    document.add(new Paragraph("Lieu de Facturation : " + client.getBillingPlace(), font));
	    
	    document.add(new Paragraph("Total Hors-Taxe : " + request.getTotalHT() + "€", font));
	    
	    document.add(new Paragraph("Total TTC : " + request.getTotalTTC() + "€", font));
	    
	    document.close();	
	    
	    
		
	}
	
	private void addTableHeader(PdfPTable table) {
	    Stream.of("Produit", "Quantité", "Prix /u", "TVA")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private void addRow(PdfPTable table, DetailsRequests dr) {
	   //ajout des valeurs de ton detail
		
		table.addCell(dr.getProduct().getName());
	    table.addCell(String.valueOf(dr.getQuantity()));
	    table.addCell(dr.getProduct().getPriceUnitWithDevise());
	    table.addCell(String.valueOf(dr.getProduct().getTva().getTauxWithPourcentage()));
	    
	    
	}
}
