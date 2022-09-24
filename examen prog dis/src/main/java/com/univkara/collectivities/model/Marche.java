package com.univkara.collectivities.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marches")
public class Marche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "emplacement")
	private String emplacement;
	
	@Column(name = "superficie")
	private String superficie;
	
	@Column(name = "heure_ouverture")
	private String heureOuverture;
	
	@Column(name = "heure_fermeture")
	private String heureFermeture;
	
	@OneToMany(
			fetch = FetchType.LAZY,
			mappedBy = "marche")
	private List<VenteProduit> venteProduits = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ville_id", referencedColumnName = "id")
	private Ville ville;
	
	@ManyToMany
	@JoinTable(
			name = "Marche_JourDeMarche",
			joinColumns = {@JoinColumn(name = "marche_id")},
			inverseJoinColumns = {@JoinColumn(name = "jour_De_Marche_id")})
	private List<JourDeMarche> jourDeMarches = new ArrayList<>();


	public Marche(String nom, String emplacement, String heureFermeture, String heureOuverture, String superficie,
			List<JourDeMarche> jourDeMarches, List<VenteProduit> venteProduits, Ville ville) {
		this.nom = nom;
		this.emplacement = emplacement;
		this.superficie = superficie;
		this.heureOuverture = heureOuverture;
		this.heureFermeture = heureFermeture;
		this.venteProduits = venteProduits;
		this.ville = ville;
		this.jourDeMarches = jourDeMarches;
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

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public String getHeureOuverture() {
		return heureOuverture;
	}

	public void setHeureOuverture(String heureOuverture) {
		this.heureOuverture = heureOuverture;
	}

	public String getHeureFermeture() {
		return heureFermeture;
	}

	public void setHeureFermeture(String heureFermeture) {
		this.heureFermeture = heureFermeture;
	}


	public List<VenteProduit> getVenteProduits() {
		return venteProduits;
	}


	public void setVenteProduits(List<VenteProduit> venteProduits) {
		this.venteProduits = venteProduits;
	}


	public List<JourDeMarche> getJourDeMarches() {
		return jourDeMarches;
	}


	public void setJourDeMarches(List<JourDeMarche> jourDeMarches) {
		this.jourDeMarches = jourDeMarches;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
	
	
}
