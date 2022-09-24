package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.JourDeMarche;

@Repository
public interface JourDeMarcheRepository extends JpaRepository<JourDeMarche, Long> {

}

