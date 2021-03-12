package com.tmidevelopment.saolourenco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tmidevelopment.saolourenco.domain.Usuario;
import com.tmidevelopment.saolourenco.repositories.UsuarioRepository;
import com.tmidevelopment.saolourenco.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

		Usuario user = repo.findByUsuario(usuario);
		if (user == null) {
			throw new UsernameNotFoundException(usuario);
		}

		return new UserSS(user.getId(), user.getUsuario(), user.getEmail(), user.getSenha(), user.getPerfis());
	}

}
