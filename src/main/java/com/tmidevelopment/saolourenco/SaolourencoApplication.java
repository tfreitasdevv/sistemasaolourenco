package com.tmidevelopment.saolourenco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tmidevelopment.saolourenco.domain.Batismo;
import com.tmidevelopment.saolourenco.domain.Celebrante;
import com.tmidevelopment.saolourenco.domain.Cidade;
import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.domain.Pessoa;
import com.tmidevelopment.saolourenco.repositories.BatismoRepository;
import com.tmidevelopment.saolourenco.repositories.CelebranteRepository;
import com.tmidevelopment.saolourenco.repositories.CidadeRepository;
import com.tmidevelopment.saolourenco.repositories.EnderecoRepository;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;
import com.tmidevelopment.saolourenco.repositories.ParoquiaRepository;
import com.tmidevelopment.saolourenco.repositories.PessoaRepository;

@SpringBootApplication
public class SaolourencoApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ParoquiaRepository paroquiaRepository;
	@Autowired
	private CelebranteRepository celebranteRepository;
	@Autowired
	private BatismoRepository batismoRepository;

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

		Endereco end1 = new Endereco(null, "Rua A", "264", "Sobrado", "Fonseca", "2412301", c1);
		Endereco end2 = new Endereco(null, "Rua B", "48", "Apto 20", "São Lourenço", "2412302", c1);
		Endereco end3 = new Endereco(null, "Rua C", "12", null, "Icaraí", "2412303", c1);
		Endereco end4 = new Endereco(null, "Rua D", "189", null, "São Domingos", "2412304", c1);
		Endereco end5 = new Endereco(null, "Rua E", "181", null, "Santa Rosa", "2412305", c1);
		Endereco end6 = new Endereco(null, "Rua F", "184", null, "Centro", "2412306", c1);
		Endereco end7 = new Endereco(null, "Rua G", "489", null, "São Lourenço", "2412307", c1);
		Endereco end8 = new Endereco(null, "Rua H", "586", null, "Fonseca", "2412308", c1);

		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6, end7, end8));

		Paroquia par1 = new Paroquia(null, "São Lourenço", end7);
		Paroquia par2 = new Paroquia(null, "Santo Cristo dos Milagres", end8);

		paroquiaRepository.saveAll(Arrays.asList(par1, par2));

		Pessoa p1 = new Pessoa(null, "Maria", null, "F", "Tiago", "Madalena", "10831125039", "maria@email.com", end1,
				par1, null);
		Pessoa p2 = new Pessoa(null, "João", null, "M", "Lucas", "Maria", "79665182056", "joao@email.com", end2, par1,
				null);
		Pessoa p3 = new Pessoa(null, "Carlos", null, "M", "Mateus", "Laura", "74626615007", "carlos@email.com", end3,
				par1, null);
		Pessoa p4 = new Pessoa(null, "Letícia", null, "F", "João", "Isabel", "63180245069", "leticia@email.com", end4,
				par1, null);
		Pessoa p5 = new Pessoa(null, "Amanda", null, "F", "Marcos", "Carla", "81667720007", "amanda@email.com", end5,
				par2, null);
		Pessoa p6 = new Pessoa(null, "Luana", null, "F", "Tadeu", "Marcia", "47058236054", "luana@email.com", end6,
				par2, null);

		p1.getTelefones().addAll(Arrays.asList("65446981", "54879651"));
		p2.getTelefones().addAll(Arrays.asList("65446982", "54879652"));
		p3.getTelefones().addAll(Arrays.asList("65446983", "54879653"));
		p4.getTelefones().addAll(Arrays.asList("65446984", "54879654"));
		p5.getTelefones().addAll(Arrays.asList("65446985", "54879655"));
		p6.getTelefones().addAll(Arrays.asList("65446986", "54879656"));

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		Celebrante cel1 = new Celebrante(null, "Ronald", "Padre", par1);
		Celebrante cel2 = new Celebrante(null, "Douglas", "Padre", par1);
		Celebrante cel3 = new Celebrante(null, "Dimas", "Diácono", par2);

		celebranteRepository.saveAll(Arrays.asList(cel1, cel2, cel3));

		Batismo bat1 = new Batismo(null, null, "51", "158", "Adriano", "Aline", null, p5, cel1);
		Batismo bat2 = new Batismo(null, null, "52", "159", "Caio", "Lívia", "Carina", p6, cel2);

		batismoRepository.saveAll(Arrays.asList(bat1, bat2));

		p5.setBatismo(bat1);
		p6.setBatismo(bat2);

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

	}

}
