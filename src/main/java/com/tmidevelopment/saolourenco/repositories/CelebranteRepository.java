package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Celebrante;

@Repository
public interface CelebranteRepository extends JpaRepository<Celebrante, Integer> {

}
