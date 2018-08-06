package org.epsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "request_billNumber")
	private Long request_billNumber;
	
    @Column(name = "quantity")
	private int quantity;
    
    @Column(name = "dateCreation")
	private String dateCreation;
    
    @Column(name = "dateDelivery")
	private String dateDelivery;
	
    @Column(name = "confirmation")
	private boolean confirmation;
	
    @Column(name = "deliveryPlace")
	private String deliveryPlace;

    
	public Long getRequest_billNumber() {
		return request_billNumber;
	}
	public void setRequest_billNumber(Long request_billNumber) {
		this.request_billNumber = request_billNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public boolean getConfirmation() {
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
}