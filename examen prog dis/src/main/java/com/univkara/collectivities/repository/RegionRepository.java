package com.univkara.collectivities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univkara.collectivities.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
