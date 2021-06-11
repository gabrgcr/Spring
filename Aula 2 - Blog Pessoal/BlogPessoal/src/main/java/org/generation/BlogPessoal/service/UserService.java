package org.generation.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.BlogPessoal.model.UserLogin;
import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

		@Autowired
		private UsuarioRepository repository;
		
		public Usuario CadastrarUsuario(Usuario user)
		{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(user.getSenha());
			user.setSenha(senhaEncoder);
			
			return repository.save(user);
		}
		
		public Optional<UserLogin> Logar(Optional<UserLogin> user)
		{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Optional<Usuario> userencode = repository.findByUser(user.get().getUser());
			if(user.isPresent() && encoder.matches(user.get().getSenha(), userencode.get().getSenha()))
			{
				String auth = user.get().getUser() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(user.get().getNome());
				
				return user;
			}
			return null;
		}

}
