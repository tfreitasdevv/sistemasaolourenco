package com.tmidevelopment.saolourenco.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Cidade;
import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.domain.Pessoa;
import com.tmidevelopment.saolourenco.dto.PessoaDTO;
import com.tmidevelopment.saolourenco.dto.PessoaNewDTO;
import com.tmidevelopment.saolourenco.repositories.EnderecoRepository;
import com.tmidevelopment.saolourenco.repositories.PessoaRepository;
import com.tmidevelopment.saolourenco.services.exceptions.DataIntegrityException;
import com.tmidevelopment.saolourenco.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Pessoa> findAll() {
		return repo.findAllByOrderByNome();
	}

	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		enderecoRepository.save(obj.getEndereco());
		obj = repo.save(obj);
		return obj;
	}

	public Pessoa update(Pessoa obj) {
		Pessoa newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Pessoa com dados vinculados");
		}
	}

	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(null, objDto.getNome(), objDto.getNascimento(), objDto.getSexo(), objDto.getNomeDoPai(),
				objDto.getNomeDaMae(), objDto.getCpf(), objDto.getEmail(), objDto.getEndereco(), objDto.getParoquia(),
				null, null, null, null);
	}

	public Pessoa fromDTO(PessoaNewDTO objDto) {
		Paroquia par = new Paroquia(objDto.getParoquiaId(), null, null);
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cid);
		Pessoa pes = new Pessoa(null, objDto.getNome(), objDto.getNascimento(), objDto.getSexo(), objDto.getNomeDoPai(),
				objDto.getNomeDaMae(), objDto.getCpf(), objDto.getEmail(), end, par, null, null, null, null);
		pes.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			pes.getTelefones().add(objDto.getTelefone2());
		}
		return pes;
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
		newObj.setNascimento(obj.getNascimento());
		newObj.setSexo(obj.getSexo());
		newObj.setNomeDoPai(obj.getNomeDoPai());
		newObj.setNomeDaMae(obj.getNomeDaMae());
		newObj.setEmail(obj.getEmail());
	}

}
