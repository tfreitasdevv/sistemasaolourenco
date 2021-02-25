package com.tmidevelopment.saolourenco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.dto.EstadoDTO;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;
import com.tmidevelopment.saolourenco.services.exceptions.DataIntegrityException;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}

	public Estado findById(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Estado insert(Estado obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Estado update(Estado obj) {
		Estado newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Estado que tenha Cidades vinculadas");
		}
	}

	public Estado fromDTO(EstadoDTO objDto) {
		return new Estado(objDto.getId(), objDto.getNome());
	}

	private void updateData(Estado newObj, Estado obj) {
		newObj.setNome(obj.getNome());
	}

}
