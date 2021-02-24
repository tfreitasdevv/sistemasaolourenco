package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.repositories.ParoquiaRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class ParoquiaService {

	@Autowired
	private ParoquiaRepository repo;


	public Paroquia findById(Integer id) {
		Optional<Paroquia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
