package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.VenteProduit;

@Repository
public interface VenteProduitRepository extends JpaRepository<VenteProduit, Long> {

}
