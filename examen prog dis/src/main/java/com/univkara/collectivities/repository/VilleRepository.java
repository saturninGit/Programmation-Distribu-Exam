package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

}
