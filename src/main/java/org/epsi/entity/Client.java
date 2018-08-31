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
	
	
	
	
// Mise à jour pour "modification" depuis l'application	
	
//	@Override
//	public String toString() {
//		return "Client [name=" + name + ", firstName=" + firstName + ", billingPlace=" + billingPlace + ", mail=" + mail + ", phone=" + phone + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
//		result = prime * result + ((billingPlace == null) ? 0 : billingPlace.hashCode());
//		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
//		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Client other = (Client) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (firstName == null) {
//			if (other.firstName != null)
//				return false;
//		} else if (!firstName.equals(other.firstName))
//			return false;
//		if (billingPlace == null) {
//			if (other.billingPlace != null)
//				return false;
//		} else if (!billingPlace.equals(other.billingPlace))
//			return false;
//		if (mail == null) {
//			if (other.mail != null)
//				return false;
//		} else if (!mail.equals(other.mail))
//			return false;
//		if (phone == null) {
//			if (other.phone != null)
//				return false;
//		} else if (!phone.equals(other.phone))
//			return false;
//		return true;
//	}
}