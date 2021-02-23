package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Batismo;

@Repository
public interface BatismoRepository extends JpaRepository<Batismo, Integer> {

}
