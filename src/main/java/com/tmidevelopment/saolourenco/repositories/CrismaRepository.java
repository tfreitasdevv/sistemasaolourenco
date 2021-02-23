package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Crisma;

@Repository
public interface CrismaRepository extends JpaRepository<Crisma, Integer> {

}
