package org.epsi.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.epsi.service.ClientService;
import org.epsi.service.RequestService;


@Controller
public class PdfController {
	
	private Font facture = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLACK);
	private Font numFacture = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.RED);
	private Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
    private Font regular = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
    private Font TabFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 13,BaseColor.WHITE);
    private Font TaRegular = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);
    private Font indice = FontFactory.getFont(FontFactory.COURIER, 7, Font.ITALIC, BaseColor.GRAY);
    
    
    private String device = " €";

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome() {
        return "menu";
    }

	@Autowired
    private ClientService clientService;
	
	@Autowired
	private RequestService requestService;
	
	//Affiche la liste des commandes du client séléctionné
	@RequestMapping(value = "/downloadPDF/{clientId}", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable(value="clientId") final Long clientId, ModelMap pModel) {
    	  	
    	//recuperation client
    	Client lClient = clientService.getIdClient(clientId);
    	//Affiche 
    	if (lClient != null) {
        	ArrayList<Request> lRequest = new ArrayList<Request>();
        	for(Request r : lClient.getFactures()) {
        		lRequest.add(r);
        	}
        	pModel.addAttribute("listRequest", lRequest);
        	pModel.addAttribute("lClient", lClient);
    	} else {
        	System.out.println("Error client null");
    	}  		
    	return new ModelAndView("listRequest");
    }
	
	//Génére un PDF de la facture du client
	@RequestMapping(value = "/Facture-Pdf", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF(@RequestParam(value="request_billNumber") Long billing) {
		
		//Récupération du numéro de facture/ID
	    Request request = requestService.getRequest(billing);

	    //Génére le nom du PDF
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    byte[] out = null;
	    Document document = new Document();
	    
	    //Création du PDF dans la page
		try {
			//Appel à la méthode d'écriture dans le PDF
			writeInPdf(document, outputStream, request);
		    out = outputStream.toByteArray();
		
		} catch (IOException|DocumentException e) {
			e.printStackTrace();
		}
	    
		//Construit la requête HTTP
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    return new ResponseEntity<>(out, headers, HttpStatus.OK);
	}
    
	//Création du document PDF et de son avec contenue à afficher
    public void writeInPdf(Document document, OutputStream os, Request request) throws DocumentException, MalformedURLException, IOException {
		PdfWriter.getInstance(document, os);
	    document.open();
	    
	  //Logo PDF placer en haut a droite du document.
	    URL url = getClass().getClassLoader().getResource("pdf.png");
		if(null != url) {		
		    System.out.println(url.toString());
		    Image img = Image.getInstance(url);
		    img.scaleToFit(100, 100);
		    img.setAbsolutePosition(500, 740);
		    document.add(img);
		} else {
			System.out.println("l'url de l'image est null");
		}

		document.add( Chunk.NEWLINE );
		
	    //Ajout du contenue Client
		Client client = request.getClient();
		//Numéro de la facture en haut de page
		Chunk title = new Chunk("Facture n°", facture);
		Chunk numFact = new Chunk(String.valueOf(request.getRequest_billNumber()), numFacture);
		Phrase phrase = new Phrase();
		phrase.add(title);
		phrase.add(numFact);
		Paragraph TitleNum = new Paragraph(phrase);
		TitleNum.setAlignment(Element.ALIGN_CENTER);
		document.add(TitleNum);
		
		document.add( Chunk.NEWLINE );
		
		//Ajout des données Client sur le PDF
  	    document.add(new Paragraph(createPhrase("Nom : ", client.getName())));
	    document.add(new Paragraph(createPhrase("Prénom : ", client.getFirstName())));
	    document.add(new Paragraph(createPhrase("Date de Commande : ", request.getDateCreation())));
	    document.add(new Paragraph(createPhrase("Lieu de Facturation : ", client.getBillingPlace())));
	    
	    document.add( Chunk.NEWLINE );
	    
	    //Tableaux de la commande du clients.
	    PdfPTable table1 = new PdfPTable(5);
	    addTableHeader(table1);
	    
	    //La commande
	    for(DetailsRequests dr : request.getDetailsRequests()) {    		    	
	    	addRow1(table1, dr);
	    }
	    
	    //Le total
	    PdfPTable table2 = new PdfPTable(2);
	    addTableHeaderTotal(table2);
	    addRow2(table2, request);
	    
	    //Ajout des Tableaux
	    document.add(table1);
	    document.add(table2);
	    
	    document.add( Chunk.NEWLINE );
	    
	    //Logo de Livraison centré
	    URL uri = getClass().getClassLoader().getResource("img_delivery.png");
		if(null != uri) {		
		    System.out.println(uri.toString());
		    Image img = Image.getInstance(uri);
		    img.scaleToFit(100, 100);
		    img.setAlignment(Image.ALIGN_CENTER);

		    document.add(img);
		} else {
			System.out.println("l'url de l'image est null");
		}
	    
	    
	    //Ajout des détails de livraison
		document.add(new Paragraph(createPhrase("Lieu de Livraison : ", request.renderDeliveryPlace())));
		document.add(new Paragraph(createPhrase("Date de livraison : ", (request.getDateDelivery() !=null ? request.getDateDelivery() : "Aucune"))));
		
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		
		
		//Ajout de la confirmation ou non du client pour cette commande.
		URL val = getClass().getClassLoader().getResource("validate.png");
		URL wrong = getClass().getClassLoader().getResource("wrong.png");
		if(null != val && null != wrong) {	
			if(request.getConfirmation() == true) {
				System.out.println(val.toString());
			    Image img = Image.getInstance(val);
			    img.scaleToFit(200, 200);
			    img.setAlignment(Image.ALIGN_CENTER);
			    
			    document.add(img);
			    
			    Paragraph textIndice = new Paragraph("Logo facture", indice);
				textIndice.setAlignment(Element.ALIGN_CENTER);
				document.add(textIndice);
			} else {
				System.out.println(wrong.toString());
			    Image img = Image.getInstance(wrong);
			    img.scaleToFit(200, 200);
			    img.setAlignment(Image.ALIGN_CENTER);
			    
			    document.add(img);
			    
			    Paragraph textIndice = new Paragraph("Logo devis", indice);
				textIndice.setAlignment(Element.ALIGN_CENTER);
				document.add(textIndice);
			}
		} else {
			System.out.println("L'image de validation ou refus n'est plus disponible");
		}

		
	    document.close();	

	}
	
	//Methode permettant de créer des phrase avec des fonts différents
	public Phrase createPhrase(String champ, String arg) {
		Chunk nom = new Chunk( champ, font);
	    Chunk nomGet = new Chunk(arg, regular);
	    Phrase phrase = new Phrase();
	    phrase.add(nom);
	    phrase.add(nomGet);
	    return phrase;
	}
	
	//Methode Affichant les champs dans un tableau
	public void addTableHeader(PdfPTable table) {
	    Stream.of("Qté", "Produit", "Unitaire", "Montant", "TVA")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setFixedHeight(20);
	        header.setBackgroundColor(BaseColor.GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle, TabFont));
	        table.addCell(header).setHorizontalAlignment(Element.ALIGN_CENTER);
	    });
	}
	
	//Methode Affichant les champs dans un tableau
	public void addTableHeaderTotal(PdfPTable table) {
		Stream.of("Total HT", "Total TTC")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setFixedHeight(20);
	        header.setBackgroundColor(BaseColor.RED);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle, TabFont));
	        table.addCell(header).setHorizontalAlignment(Element.ALIGN_CENTER);
	    });
	}
	
	//Permet d'ajouter mes lignes de commande à mon tabeau.
	public void addRow1(PdfPTable table, DetailsRequests dr) {
		
		PdfPCell header = new PdfPCell();
		header.setBorderWidth(2);
		header.setFixedHeight(20);
		header.setPhrase(new Phrase(String.valueOf(dr.getQuantity()), TaRegular));
		table.addCell(header).setHorizontalAlignment(Element.ALIGN_CENTER);
		
		header.setFixedHeight(20);
		header.setPhrase(new Phrase(String.valueOf(dr.getProduct().getName()), TaRegular));
        table.addCell(header);
        
        header.setFixedHeight(20);
        header.setPhrase(new Phrase(String.valueOf(dr.getProduct().getPriceUnit() + device), TaRegular));
	    table.addCell(header).setHorizontalAlignment(Element.ALIGN_RIGHT);
	    
	    header.setFixedHeight(20);
	    header.setPhrase(new Phrase(String.valueOf(dr.getPriceHT() + device), TaRegular));
	    table.addCell(header).setHorizontalAlignment(Element.ALIGN_RIGHT);
	    
	    header.setFixedHeight(20);
	    header.setPhrase(new Phrase(String.valueOf(dr.getProduct().getTva().getTauxWithPourcentage()), TaRegular));
	    table.addCell(header).setHorizontalAlignment(Element.ALIGN_RIGHT);
	    
	    
	}
	
	//Permet d'ajouter mes lignes des totaux à mon tabeau.
	public void addRow2(PdfPTable table, Request request) {
		PdfPCell header = new PdfPCell();
		header.setFixedHeight(20);
		header.setBorderWidth(2);
		header.setPhrase(new Phrase(String.valueOf(request.getTotalHT() + device), TaRegular));
		table.addCell(header).setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setFixedHeight(20);
		header.setPhrase(new Phrase(String.valueOf(request.getTotalTTC() + device), TaRegular));
	    table.addCell(header).setHorizontalAlignment(Element.ALIGN_CENTER);
	    
	}
}