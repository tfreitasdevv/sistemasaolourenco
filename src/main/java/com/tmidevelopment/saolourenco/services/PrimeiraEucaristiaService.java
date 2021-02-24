package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.PrimeiraEucaristia;
import com.tmidevelopment.saolourenco.repositories.PrimeiraEucaristiaRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class PrimeiraEucaristiaService {

	@Autowired
	private PrimeiraEucaristiaRepository repo;


	public PrimeiraEucaristia findById(Integer id) {
		Optional<PrimeiraEucaristia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
