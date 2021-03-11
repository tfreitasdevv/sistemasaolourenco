package com.tmidevelopment.saolourenco.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Batismo;
import com.tmidevelopment.saolourenco.domain.Casamento;
import com.tmidevelopment.saolourenco.domain.Celebrante;
import com.tmidevelopment.saolourenco.domain.Cidade;
import com.tmidevelopment.saolourenco.domain.Crisma;
import com.tmidevelopment.saolourenco.domain.Endereco;
import com.tmidevelopment.saolourenco.domain.Estado;
import com.tmidevelopment.saolourenco.domain.Paroquia;
import com.tmidevelopment.saolourenco.domain.Perfil;
import com.tmidevelopment.saolourenco.domain.Pessoa;
import com.tmidevelopment.saolourenco.domain.PrimeiraEucaristia;
import com.tmidevelopment.saolourenco.domain.Usuario;
import com.tmidevelopment.saolourenco.repositories.BatismoRepository;
import com.tmidevelopment.saolourenco.repositories.CasamentoRepository;
import com.tmidevelopment.saolourenco.repositories.CelebranteRepository;
import com.tmidevelopment.saolourenco.repositories.CidadeRepository;
import com.tmidevelopment.saolourenco.repositories.CrismaRepository;
import com.tmidevelopment.saolourenco.repositories.EnderecoRepository;
import com.tmidevelopment.saolourenco.repositories.EstadoRepository;
import com.tmidevelopment.saolourenco.repositories.ParoquiaRepository;
import com.tmidevelopment.saolourenco.repositories.PerfilRepository;
import com.tmidevelopment.saolourenco.repositories.PessoaRepository;
import com.tmidevelopment.saolourenco.repositories.PrimeiraEucaristiaRepository;
import com.tmidevelopment.saolourenco.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
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
	@Autowired
	private CrismaRepository crismaRepository;
	@Autowired
	private CasamentoRepository casamentoRepository;
	@Autowired
	private PrimeiraEucaristiaRepository primeiraEucaristiaRepository;

	public void instantiateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Perfil perfil1 = new Perfil(null, "ROLE_ADMIN");
		Perfil perfil2 = new Perfil(null, "ROLE_DEFAULT");

		perfilRepository.saveAll(Arrays.asList(perfil1, perfil2));

		Usuario user1 = new Usuario(null, "admin", "admin");
		Usuario user2 = new Usuario(null, "thiago.freitas", "123456");

		user1.getPerfis().addAll(Arrays.asList(perfil1, perfil2));
		user2.getPerfis().addAll(Arrays.asList(perfil2));

		usuarioRepository.saveAll(Arrays.asList(user1, user2));

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

		Pessoa p1 = new Pessoa(null, "Maria", sdf.parse("06/08/1991"), "F", "Tiago", "Madalena", "10831125039",
				"maria@email.com", end1, par1, null, null, null, null);
		Pessoa p2 = new Pessoa(null, "João", sdf.parse("03/08/1990"), "M", "Lucas", "Maria", "79665182056",
				"joao@email.com", end2, par1, null, null, null, null);
		Pessoa p3 = new Pessoa(null, "Carlos", sdf.parse("13/05/1989"), "M", "Mateus", "Laura", "74626615007",
				"carlos@email.com", end3, par1, null, null, null, null);
		Pessoa p4 = new Pessoa(null, "Letícia", sdf.parse("18/06/1988"), "F", "João", "Isabel", "63180245069",
				"leticia@email.com", end4, par1, null, null, null, null);
		Pessoa p5 = new Pessoa(null, "Amanda", sdf.parse("25/01/2019"), "F", "Marcos", "Carla", "81667720007",
				"amanda@email.com", end5, par2, null, null, null, null);
		Pessoa p6 = new Pessoa(null, "Luana", sdf.parse("16/05/2018"), "F", "Tadeu", "Marcia", "47058236054",
				"luana@email.com", end6, par2, null, null, null, null);

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

		Batismo bat1 = new Batismo(null, sdf.parse("16/02/2021"), "51", "158", "Adriano", "Aline", null, p5, cel1);
		Batismo bat2 = new Batismo(null, sdf.parse("17/02/2021"), "52", "159", "Caio", "Lívia", "Carina", p6, cel2);

		batismoRepository.saveAll(Arrays.asList(bat1, bat2));

		Crisma cri1 = new Crisma(null, sdf.parse("09/02/2021"), "54", "161", "Rodrigo", p1, cel1);

		crismaRepository.saveAll(Arrays.asList(cri1));

		Casamento cas1 = new Casamento(null, sdf.parse("10/02/2021"), "53", "160", p3, p4, cel1);
		cas1.getTestemunhas().addAll(Arrays.asList("Maria", "José"));

		casamentoRepository.saveAll(Arrays.asList(cas1));

		PrimeiraEucaristia pri1 = new PrimeiraEucaristia(null, sdf.parse("08/02/2021"), "55", "162", p2, cel1);
		pri1.getCatequistas().addAll(Arrays.asList("Carla", "Bruna"));

		primeiraEucaristiaRepository.saveAll(Arrays.asList(pri1));

		p5.setBatismo(bat1);
		p6.setBatismo(bat2);
		p1.setCrisma(cri1);
		p3.setCasamento(cas1);
		p4.setCasamento(cas1);
		p2.setPrimeiraEucaristia(pri1);

		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

	}

}
