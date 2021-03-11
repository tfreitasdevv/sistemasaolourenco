package com.tmidevelopment.saolourenco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmidevelopment.saolourenco.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
