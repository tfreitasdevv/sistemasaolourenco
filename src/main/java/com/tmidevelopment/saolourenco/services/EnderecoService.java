package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.repositories.EnderecoRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;


	public Endereco findById(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
