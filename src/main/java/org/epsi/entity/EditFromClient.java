package org.epsi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

public class EditFromClient {

	private Long client_id;
	
	@NotEmpty(message="{NotEmpty.edit.name}")
	private String name;
	
	@NotEmpty(message="{NotEmpty.edit.firstName}")
	private String firstName;
	
	@NotEmpty(message="{NotEmpty.edit.billingPlace}")
	private String billingPlace;
	
	@NotEmpty(message="{NotEmpty.edit.mail}")
	private String mail;
	
	@NotEmpty(message="{NotEmpty.edit.phone}")
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

	public void setFactures(Set<Request> factures) {
		this.factures = factures;
	}
	
}