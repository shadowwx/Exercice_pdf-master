package org.epsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_reference;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "numberStock")
	private int numberStock;
	
	@Column(name = "priceUnit")
	private float priceUnit;
	
	@Column(name = "commentary")
	private String commentary;
	
	public Product() {
		super();
	}
	
	public Product(Long product_reference, String name, String brand, String type, float weight, int numberStock,
			float priceUnit, String commentary) {
		super();
		this.product_reference = product_reference;
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.weight = weight;
		this.numberStock = numberStock;
		this.priceUnit = priceUnit;
		this.commentary = commentary;
	}
	public Long getProduct_reference() {
		return product_reference;
	}
	public void setProduct_reference(Long product_reference) {
		this.product_reference = product_reference;
	}
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
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getNumberStock() {
		return numberStock;
	}
	public void setNumberStock(int numberStock) {
		this.numberStock = numberStock;
	}
	public float getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(float priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
}
