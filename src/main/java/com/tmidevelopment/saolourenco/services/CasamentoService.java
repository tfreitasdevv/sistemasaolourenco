package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Casamento;
import com.tmidevelopment.saolourenco.repositories.CasamentoRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class CasamentoService {

	@Autowired
	private CasamentoRepository repo;


	public Casamento findById(Integer id) {
		Optional<Casamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
