package com.tmidevelopment.saolourenco.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmidevelopment.saolourenco.domain.Estado;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@GetMapping
	public List<Estado> listar() {

		Estado e1 = new Estado(1, "RJ");
		Estado e2 = new Estado(2, "SP");

		List<Estado> lista = new ArrayList<>();
		lista.add(e1);
		lista.add(e2);

		return lista;
	}

}
