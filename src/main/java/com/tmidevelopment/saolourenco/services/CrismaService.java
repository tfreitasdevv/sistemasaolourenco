package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Crisma;
import com.tmidevelopment.saolourenco.repositories.CrismaRepository;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class CrismaService {

	@Autowired
	private CrismaRepository repo;

	public Crisma findById(Integer id) {
		Optional<Crisma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
