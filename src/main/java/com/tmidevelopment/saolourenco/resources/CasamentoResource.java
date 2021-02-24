package com.tmidevelopment.saolourenco.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmidevelopment.saolourenco.domain.Casamento;
import com.tmidevelopment.saolourenco.services.CasamentoService;

@RestController
@RequestMapping(value = "/casamentos")
public class CasamentoResource {

	@Autowired
	private CasamentoService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Casamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
