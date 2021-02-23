package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Casamento;

@Repository
public interface CasamentoRepository extends JpaRepository<Casamento, Integer> {

}
