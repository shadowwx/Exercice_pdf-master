package org.epsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Permet de manipuler le détails des commandes pour chaque produit commandé (détailsRequests)

@Entity
@Table(name="detailsrequests")
public class DetailsRequests {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "detailsRequests_id")
	private Long detailsRequests_id;
		
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_reference", insertable=false, updatable=false, nullable=false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "request_billNumber", insertable=false, updatable=false, nullable=false)
    private Request request;
	
    @Column(name = "quantity")
	private int quantity;

	public Long getDetailsRequests_id() {
		return detailsRequests_id;
	}

	public void setDetailsRequests_id(Long detailsRequests_id) {
		this.detailsRequests_id = detailsRequests_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DetailsRequests [detailsRequests_id=" + detailsRequests_id + ", product=" + product
				+ ", request=" + request + ", quantity=" + quantity + "]";
	}
	
	public float getPriceHT() {
		return getQuantity()*getProduct().getPriceUnit();
	}
	
	public float getPriceTTC() {
		return getQuantity()*getProduct().getPriceUnitTTC();
	}
	
}
