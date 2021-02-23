package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.PrimeiraEucaristia;

@Repository
public interface PrimeiraEucaristiaRepository extends JpaRepository<PrimeiraEucaristia, Integer> {

}
