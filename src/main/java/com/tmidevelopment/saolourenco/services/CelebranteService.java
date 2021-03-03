package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Celebrante;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.dto.CelebranteDTO;
import com.tmidevelopment.saolourenco.dto.CelebranteNewDTO;
import com.tmidevelopment.saolourenco.repositories.CelebranteRepository;
import com.tmidevelopment.saolourenco.services.exceptions.DataIntegrityException;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class CelebranteService {

	@Autowired
	private CelebranteRepository repo;

	public Celebrante findById(Integer id) {
		Optional<Celebrante> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Transactional
	public Celebrante insert(Celebrante obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Celebrante update(Celebrante obj) {
		Celebrante newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Paróquia que tenha pessoas ou celebrantes vinculados");
		}
	}

	public Celebrante fromDTO(CelebranteDTO objDto) {
		return new Celebrante(objDto.getId(), objDto.getNome(), objDto.getFuncao(), objDto.getParoquia());
	}

	public Celebrante fromDTO(CelebranteNewDTO objDto) {
		Paroquia par = new Paroquia(objDto.getParoquiaId(), null, null);
		Celebrante cel = new Celebrante(null, objDto.getNome(), objDto.getFuncao(), par);
		return cel;
	}

	private void updateData(Celebrante newObj, Celebrante obj) {
		newObj.setNome(obj.getNome());
		newObj.setFuncao(obj.getFuncao());
	}

}
