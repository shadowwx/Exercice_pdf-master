package org.epsi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.epsi.dao.ProductCsvDao;
import org.epsi.entity.Product;
import org.epsi.entity.Tva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCsvServiceImpl implements ProductCsvService {

	@Autowired
	private ProductCsvDao productCsvDao;
	
	@Transactional
	public List<Product> getProducts() {
		return productCsvDao.getProducts();
	}
	
    BufferedReader br = null;
    String line = null;
    String cvsSplit = ";";
	
    
    //Permet de lire le CSV
	@Transactional
	public List<Product> readCsvProduct(InputStream file) {

    	br = new BufferedReader(new InputStreamReader(file));
    	List<Product> productList = new ArrayList<Product>();
        //Cette boucle permet de séparé chaque ligne et de boucler jusqu'a qu'il n'y en est plus.
			try {
				while ((line = br.readLine()) != null) {
				    // Permet de s�par� les occurences
				    String[] splitProduct= line.split(cvsSplit);
				    float weight = Float.parseFloat((splitProduct[3]));
				    int numberStock = Integer.parseInt(splitProduct[4]);
				    float priceUnit = Float.parseFloat((splitProduct[5]));
				    Long tva_id = Long.parseLong((splitProduct[7]));
				    Tva tva = new Tva(tva_id);
				    
				    Product product = new Product(splitProduct[0], splitProduct[1], splitProduct[2], weight,
				    		numberStock, priceUnit, splitProduct[6], tva);
				    productList.add(product);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return productList;
	}

	//Envoi les données tiré du fichier en BDD
	@Transactional
    public void persistImportProduct(List<Product> product) {
		for(int i=0 ; i<product.size() ; i++) {
			productCsvDao.importProduct(product.get(i));
		}
    }
}