package org.epsi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;



public class CreationFromRequest {

    @NotEmpty(message="{NotEmpty.edit.request_billNumber}")
	private Long request_billNumber;
    
    @NotEmpty(message="{NotEmpty.edit.dateCreation}")
	private String dateCreation;
    
    @NotEmpty(message="{NotEmpty.edit.dateDelivery}")
	private String dateDelivery;
	
    @NotEmpty(message="{NotEmpty.edit.confirmation}")
	private boolean confirmation;

    @NotEmpty(message="{NotEmpty.edit.deliveryPlace}")
	private String deliveryPlace;
    
    @NotEmpty(message="{NotEmpty.edit.client_id}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", insertable=false, updatable=false, nullable=false)
    private Client client;
    
    @OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			targetEntity = DetailsRequests.class,
            mappedBy = "request")
    private Set<DetailsRequests> detailsRequests = new HashSet<>();
    

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<DetailsRequests> getDetailsRequests() {
		return detailsRequests;
	}

	public void setDetailsRequests(Set<DetailsRequests> detailsRequests) {
		this.detailsRequests = detailsRequests;
	}
    
}