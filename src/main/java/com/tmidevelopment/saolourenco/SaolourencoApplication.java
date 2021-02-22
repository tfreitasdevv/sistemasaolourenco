package com.tmidevelopment.saolourenco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;

@SpringBootApplication
public class SaolourencoApplication implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SaolourencoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null, "RJ");
		Estado e2 = new Estado(null, "SP");
		Estado e3 = new Estado(null, "MG");
		
		estadoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
	}

}
