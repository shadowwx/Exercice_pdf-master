package org.epsi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "request_billNumber")
	private Long request_billNumber;
    
    @Column(name = "dateCreation")
	private String dateCreation;
    
    @Column(name = "dateDelivery")
	private String dateDelivery;
	
    @Column(name = "confirmation")
	private boolean confirmation;
	
    @Column(name = "deliveryPlace")
	private String deliveryPlace;
    
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
	
	public void setClient(Client client) {
		this.client = client;
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
	
	public Set<DetailsRequests> getDetailsRequests() {
		return detailsRequests;
	}

	public void setDetailsRequests(Set<DetailsRequests> detailsRequests) {
		this.detailsRequests = detailsRequests;
	}

	public Client getClient() {
		return client;
	}

	public String renderDeliveryPlace(){
		if(getDeliveryPlace() == null) {
			return "Aucune";
		}
		return getDeliveryPlace();
	}
	
	public float getTotalHT() {
		float myTotalHT = 0;
		for(DetailsRequests md :  getDetailsRequests()) {
			myTotalHT += md.getPriceHT();
		}		
		return myTotalHT;
	}
	
	public float getTotalTTC() {
		float myTotalTTC = 0;
		for(DetailsRequests md :  getDetailsRequests()) {
			myTotalTTC += md.getPriceTTC();
		}		
		return myTotalTTC;
	}
	
	@Override
	public String toString() {
		return "Request [request_billNumber=" + request_billNumber + ", dateCreation=" + dateCreation
				+ ", dateDelivery=" + dateDelivery + ", confirmation=" + confirmation + ", deliveryPlace="
				+ deliveryPlace + "]";
	}


	
}