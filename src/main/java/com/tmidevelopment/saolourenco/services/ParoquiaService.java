package com.tmidevelopment.saolourenco.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Cidade;
import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.dto.ParoquiaDTO;
import com.tmidevelopment.saolourenco.dto.ParoquiaNewDTO;
import com.tmidevelopment.saolourenco.repositories.EnderecoRepository;
import com.tmidevelopment.saolourenco.repositories.ParoquiaRepository;
import com.tmidevelopment.saolourenco.services.exceptions.DataIntegrityException;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class ParoquiaService {

	@Autowired
	private ParoquiaRepository repo;
	@Autowired
	private EnderecoRepository enderecoRepository;
	//@Autowired
	//private CidadeRepository cidadeRepository;

	public Paroquia findById(Integer id) {
		Optional<Paroquia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Transactional
	public Paroquia insert(Paroquia obj) {
		obj.setId(null);
		enderecoRepository.save(obj.getEndereco());
		obj = repo.save(obj);
		return obj;
	}

	public Paroquia update(Paroquia obj) {
		Paroquia newObj = findById(obj.getId());
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

	public Paroquia fromDTO(ParoquiaDTO objDto) {
		return new Paroquia(objDto.getId(), objDto.getNome(), null);
	}

	public Paroquia fromDTO(ParoquiaNewDTO objDto) {
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cid);
		Paroquia par = new Paroquia(null, objDto.getNome(), end);
		return par;
	}

	private void updateData(Paroquia newObj, Paroquia obj) {
		newObj.setNome(obj.getNome());
	}

}
