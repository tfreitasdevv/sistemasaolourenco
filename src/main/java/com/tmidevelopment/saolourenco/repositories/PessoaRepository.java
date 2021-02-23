package com.tmidevelopment.saolourenco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tmidevelopment.saolourenco.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	@Transactional(readOnly = true)
	public List<Pessoa> findAllByOrderByNome();

}
