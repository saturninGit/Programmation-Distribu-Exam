package com.univkara.collectivities.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vente_produit")
public class VenteProduit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "prix_unitaire")
	private int prixUnitaire;
	
	@Column(name = "quantite")
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "produit_id", referencedColumnName = "id")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "marche_id",referencedColumnName = "id")
	private Marche marche;
	
	@ManyToOne
	@JoinColumn(name = "ville_id",referencedColumnName = "id")
	private Ville ville;



	public VenteProduit(int prixUnitaire, int quantite) {
		super();
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Marche getMarche() {
		return marche;
	}


	public void setMarche(Marche marche) {
		this.marche = marche;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
}
