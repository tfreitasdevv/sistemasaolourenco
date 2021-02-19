package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public Estado findById(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
