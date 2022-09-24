package com.univkara.collectivities.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.Marche;

@Repository
public interface MarcheRepository extends JpaRepository<Marche, Long> {
	
	
}

