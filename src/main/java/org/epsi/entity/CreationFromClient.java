package org.epsi.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class CreationFromClient {

    @NotEmpty
    private String name;
    
    @NotEmpty
    private String firstName;
    
    @NotEmpty
    private String billingPlace;
    

    private String mail;
    
    @NotEmpty
    private String phone;

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
