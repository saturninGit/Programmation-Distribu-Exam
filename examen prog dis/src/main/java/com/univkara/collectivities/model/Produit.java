package com.univkara.collectivities.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "type")
	private TypeProduit type;
	
	@OneToMany(
			fetch = FetchType.LAZY,
			mappedBy = "produit")
	private List<VenteProduit> venteProduits = new ArrayList<>();

	public Produit(String nom, TypeProduit type) {
		super();
		this.nom = nom;
		this.type = type;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeProduit getType() {
		return type;
	}

	public void setType(TypeProduit type) {
		this.type = type;
	}


	public List<VenteProduit> getVenteProduits() {
		return venteProduits;
	}


	public void setVenteProduits(List<VenteProduit> venteProduits) {
		this.venteProduits = venteProduits;
	}

	
	
	
}
