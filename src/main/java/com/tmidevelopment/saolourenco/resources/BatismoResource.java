package com.tmidevelopment.saolourenco.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmidevelopment.saolourenco.domain.Batismo;
import com.tmidevelopment.saolourenco.services.BatismoService;

@RestController
@RequestMapping(value = "/batismos")
public class BatismoResource {

	@Autowired
	private BatismoService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Batismo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
