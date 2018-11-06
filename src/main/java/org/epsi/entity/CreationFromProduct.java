package org.epsi.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

//Permet de manipuler les données produit lors de la création, affiche différente erreurs.

public class CreationFromProduct {
	
	private Long reference_product;

    @NotEmpty(message="{NotEmpty.creation.name}")
    private String name;
    
    @NotEmpty(message="{NotEmpty.creation.brand}")
    private String brand;
    
    @NotEmpty(message="{NotEmpty.creation.type}")
    private String type;
    
    @Pattern(regexp="\\d+(\\.\\d{1,2})?|(^$)", message="{NotEmpty.creation.reg.weight}")
    private String weight;
    
    @NotEmpty(message="{NotEmpty.creation.numberStock}")
    @Pattern(regexp="\\d*")
    private String numberStock;
    
    @NotEmpty(message="{NotEmpty.creation.priceUnit}")
    @Pattern(regexp="\\d+(\\.\\d{1,2})?", message="{NotEmpty.creation.reg.priceUnit}")
    private String priceUnit ;
    
    private String commentary;
    
    private Long Tva;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getNumberStock() {
		return numberStock;
	}

	public void setNumberStock(String numberStock) {
		this.numberStock = numberStock;
	}

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Long getReference_product() {
		return reference_product;
	}

	public void setReference_product(Long reference_product) {
		this.reference_product = reference_product;
	}

	public Long getTva() {
		return Tva;
	}

	public void setTva(Long tva) {
		Tva = tva;
	}

}