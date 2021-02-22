package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Paroquia;

@Repository
public interface ParoquiaRepository extends JpaRepository<Paroquia, Integer> {

}
