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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long client_id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "billingPlace")
	private String billingPlace;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "phone")
	private String phone;
		
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			targetEntity = Request.class,
            mappedBy = "client")
    private Set<Request> factures = new HashSet<>();

	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getBillingPlace() {
		return billingPlace;
	}
	public void setBillingPlace(String billingPlace) {
		this.billingPlace = billingPlace;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Request> getFactures() {
		return factures;
	}
	
	public Client() {
		
	}

	public Client(String name, String firstName, String billingPlace, String mail, String phone) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.billingPlace = billingPlace;
		this.mail = mail;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", name=" + name + ", firstName=" + firstName + ", billingPlace="
				+ billingPlace + ", mail=" + mail + ", phone=" + phone + ", factures=" + factures + "]";
	}

}