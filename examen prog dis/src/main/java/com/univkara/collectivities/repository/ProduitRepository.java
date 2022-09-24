package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
