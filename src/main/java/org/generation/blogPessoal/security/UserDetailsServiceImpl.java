package org.generation.blogPessoal.security;

import java.util.Optional;

import org.generation.blogPessoal.model.User;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private @Autowired UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = repository.findByUsuario(username);

		if (user.isPresent()) {
			return new UserDetailsImpl(user.get());
		} else {
			throw new UsernameNotFoundException("Usuario não existe");
		}
	}
}