package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Celebrante;
import com.tmidevelopment.saolourenco.repositories.CelebranteRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class CelebranteService {

	@Autowired
	private CelebranteRepository repo;


	public Celebrante findById(Integer id) {
		Optional<Celebrante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
