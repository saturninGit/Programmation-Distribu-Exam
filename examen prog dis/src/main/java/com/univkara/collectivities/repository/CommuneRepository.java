package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.Commune;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {
	
}
