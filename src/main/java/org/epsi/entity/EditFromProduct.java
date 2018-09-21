package org.epsi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

public class EditFromProduct {

	private Long product_reference;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private String name;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private String brand;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private String type;
	
	
	private float weight;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private int numberStock;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private float priceUnit;
	
	private String commentary;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tva_id", nullable=false)
    private Tva tva;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			targetEntity = DetailsRequests.class,
            mappedBy = "product")
    private Set<DetailsRequests> detailsRequests = new HashSet<>();

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

	public Tva getTva() {
		return tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	public Set<DetailsRequests> getDetailsRequests() {
		return detailsRequests;
	}

	public void setDetailsRequests(Set<DetailsRequests> detailsRequests) {
		this.detailsRequests = detailsRequests;
	}

}