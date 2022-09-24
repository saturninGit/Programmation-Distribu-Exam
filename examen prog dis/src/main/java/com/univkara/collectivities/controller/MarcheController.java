package com.univkara.collectivities.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univkara.collectivities.model.Marche;
import com.univkara.collectivities.repository.MarcheRepository;

@RestController
@RequestMapping("/api")
public class MarcheController {

	@Autowired
	private MarcheRepository marcheRepository;
	
	//get all markets
	/*@GetMapping("/marches")
	public List<Marche> getAllMAarkets(){
		return marcheRepository.findAll();
	}*/
	@GetMapping("/marches")
	public ResponseEntity<List<Marche>> getAllMarches(@RequestParam(required = false) String nom){
		try {
			List<Marche> marches = new ArrayList<Marche>();
			if(marches.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(marches, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get market by id
	@GetMapping("/marches/{id}")
	public ResponseEntity<Marche> getMarcheById(@PathVariable("id") long id) {
		Optional<Marche> marcheData = marcheRepository.findById(id);
		if (marcheData.isPresent()) {
			return new ResponseEntity<>(marcheData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
		
	//create market
	@PostMapping("marches")
	public ResponseEntity<Marche> createMarche(@RequestBody Marche marche) {
		try {
			Marche _marche = marcheRepository
					.save(new Marche(marche.getNom(), marche.getEmplacement(), marche.getHeureFermeture(), marche.getHeureOuverture(), marche.getSuperficie(), marche.getJourDeMarches(), marche.getVenteProduits(), marche.getVille() ));
			return new ResponseEntity<>(_marche, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	//update market information
	@PutMapping("/marches/{id}")
	public ResponseEntity<Marche> updateMarche(@PathVariable("id") long id, @RequestBody Marche marche){
		Optional<Marche> marcheData = marcheRepository.findById(id);
		if(marcheData.isPresent()) {
			Marche _marche = marcheData.get();
			_marche.setNom(marche.getNom());
			_marche.setEmplacement(marche.getEmplacement());
			_marche.setSuperficie(marche.getSuperficie());
			_marche.setHeureOuverture(marche.getHeureOuverture());
			_marche.setHeureFermeture(marche.getHeureFermeture());
			_marche.setVenteProduits(marche.getVenteProduits());
			_marche.setVille(marche.getVille());
			_marche.setJourDeMarches(marche.getJourDeMarches());
			return new ResponseEntity<>(marcheRepository.save(_marche), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete market
	@DeleteMapping("/marches/{id}")
	public ResponseEntity<HttpStatus> deleteMarche(@PathVariable("id") long id){
		try {
			marcheRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//delete all markets
	@DeleteMapping("/marches")
	public ResponseEntity<HttpStatus> deleteAllMarche(){
		try {
			marcheRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	
	
}
