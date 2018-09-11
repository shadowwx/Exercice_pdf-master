package org.epsi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tva")
public class Tva {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tva_id")
	private Long tva_id;

	@Column(name = "taux")
	private float taux;

	@Column(name = "nom")
	private String nom;

	@OneToMany(cascade = CascadeType.ALL,
			targetEntity = Product.class,
            mappedBy = "tva")
    private Set<Product> products = new HashSet<>();
	
	public Long getTva_id() {
		return tva_id;
	}

	public void setTva_id(Long tva_id) {
		this.tva_id = tva_id;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public String getTauxWithPourcentage() {
		return getTaux() + "%";
	}

	public Tva(Long tva_id, float taux, String nom, Set<Product> products) {
		super();
		this.tva_id = tva_id;
		this.taux = taux;
		this.nom = nom;
		this.products = products;
	}
	
	public Tva(Long tva_id) {
		super();
		this.tva_id = tva_id;
	}

	public Tva() {
		super();
	}

	@Override
	public String toString() {
		return "Tva [tva_id=" + tva_id + ", taux=" + taux + ", nom=" + nom + "]";
	}

}