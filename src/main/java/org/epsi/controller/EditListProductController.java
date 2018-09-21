package org.epsi.controller;

import org.epsi.entity.Product;
import org.epsi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditListProductController {

	@Autowired
    private ProductService productService;

    @RequestMapping(value="/displayEditProduct/{product_reference}", method = RequestMethod.GET)
    public String display(@PathVariable(value="product_reference") final Long product_reference, ModelMap pModel) {
    	Product product = productService.getFindProductReference(product_reference);
    	pModel.addAttribute("editProduct", product);
        return "editProduct";
    }
    
    @RequestMapping(value="/displayEditProduct/editProduct", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value="editProduct") Product editFromProduct, 
            final BindingResult pBindingResult, final ModelMap pModel) {
        if (!pBindingResult.hasErrors()) {
        	Product product = productService.getFindProductReference(editFromProduct.getProduct_reference());
        	product.setName(editFromProduct.getName());
        	product.setBrand(editFromProduct.getBrand());
        	product.setType(editFromProduct.getType());
        	product.setWeight(editFromProduct.getWeight());
        	product.setNumberStock(editFromProduct.getNumberStock());
        	product.setPriceUnit(editFromProduct.getPriceUnit());
        	product.setCommentary(editFromProduct.getCommentary());
        	//product.setTva(editFromProduct.getTva());
        	
        	
            final Product editedProduct = product;
            productService.persistEditProduct(editedProduct);
        }
        return "redirect:/product";
    }
}
