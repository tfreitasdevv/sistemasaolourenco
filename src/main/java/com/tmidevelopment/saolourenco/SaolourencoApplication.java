package com.tmidevelopment.saolourenco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tmidevelopment.saolourenco.domain.Cidade;
import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.repositories.CidadeRepository;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;

@SpringBootApplication
public class SaolourencoApplication implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SaolourencoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null, "RJ");
		Estado e2 = new Estado(null, "SP");
		Estado e3 = new Estado(null, "MG");
		
		Cidade c1 = new Cidade(null, "Niterói", e1);
		Cidade c2 = new Cidade(null, "São Gonçalo", e1);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(c1, c2));
		e2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2, e3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}
