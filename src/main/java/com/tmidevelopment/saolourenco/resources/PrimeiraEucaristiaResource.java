package com.tmidevelopment.saolourenco.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmidevelopment.saolourenco.domain.PrimeiraEucaristia;
import com.tmidevelopment.saolourenco.services.PrimeiraEucaristiaService;

@RestController
@RequestMapping(value = "/primeirasEucaristias")
public class PrimeiraEucaristiaResource {

	@Autowired
	private PrimeiraEucaristiaService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		PrimeiraEucaristia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
