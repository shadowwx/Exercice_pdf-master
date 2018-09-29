package org.epsi.entity;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreationFromRequest {

	private Long request_billNumber;
    
	private String dateCreation;
    
	private String dateDelivery;
	
	private boolean confirmation;

	private String deliveryPlace;
    
    private Long clientId;
    
    private List<Product> products = new ArrayList<>();
    
    private List<Integer> quantities = new ArrayList<>();
    
    private Set<DetailsRequests> detailsRequests = new HashSet<>();
    
    public CreationFromRequest()
    {
    	this.dateCreation = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }
    
	public Long getRequest_billNumber() {
		return request_billNumber;
	}

	public void setRequest_billNumber(Long request_billNumber) {
		this.request_billNumber = request_billNumber;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(String dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Set<DetailsRequests> getDetailsRequests() {
		return detailsRequests;
	}

	public void setDetailsRequests(Set<DetailsRequests> detailsRequests) {
		this.detailsRequests = detailsRequests;
	}
	
	public String toString()
	{
		StringBuilder strB = new StringBuilder();
		for(Field field : this.getClass().getDeclaredFields())
		{
			try {
				strB.append(field.getName() + " - " + (field.get(this) != null ? field.get(this) : "vide") + "\n");
			} catch (Exception e) {
				
			}
		}
		return strB.toString();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}
    
}