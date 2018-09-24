package org.epsi.entity;

import org.hibernate.validator.constraints.NotEmpty;

//Permet de manipuler les données d'un client lors de la création, affiche différentes erreurs.

public class CreationFromClient {
	
    private Long client_id;

	@NotEmpty(message="{NotEmpty.edit.name}")
	private String name;
	
	@NotEmpty(message="{NotEmpty.edit.firstName}")
	private String firstName;
	
	@NotEmpty(message="{NotEmpty.edit.billingPlace}")
	private String billingPlace;
	
	private String mail;
	
	@NotEmpty(message="{NotEmpty.edit.phone}")
	private String phone;

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

}