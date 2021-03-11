package com.tmidevelopment.saolourenco.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmidevelopment.saolourenco.domain.Pessoa;
import com.tmidevelopment.saolourenco.dto.PessoaNewDTO;
import com.tmidevelopment.saolourenco.repositories.PessoaRepository;
import com.tmidevelopment.saolourenco.resources.exceptions.FieldMessage;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaNewDTO> {

	@Autowired
	private PessoaRepository repo;

	@Override
	public void initialize(PessoaInsert ann) {
	}

	@Override
	public boolean isValid(PessoaNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista

		Pessoa aux = repo.findByCpf(objDto.getCpf());
		if (aux != null) {
			list.add(new FieldMessage("cpf", "CPF já cadastrado no sistema"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}