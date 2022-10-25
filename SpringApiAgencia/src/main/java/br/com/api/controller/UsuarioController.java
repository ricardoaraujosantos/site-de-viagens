package br.com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.utils.SenhaUtils;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Listar
	@GetMapping("/list/user")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	// criar
	@PostMapping("/user/add")
	public Usuario adicionar(@RequestBody Usuario usuario) {
		String senhaEncriptada = SenhaUtils.encode(usuario.getSenha());
		usuario.setSenha(senhaEncriptada);
		return usuarioRepository.save(usuario);
	}

	// Listar por id
	@GetMapping("/listar/user/{id}")
	Usuario listarporId(@PathVariable Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}

	// Atualizar
	@PutMapping("user/update/{id}")
	Usuario atualizar(@RequestBody Usuario newUser, @PathVariable Long id) {
		Usuario usuarioAtualizado = usuarioRepository.findById(id).map(user -> {
			user.setNome(newUser.getNome());
			user.setEndereco(newUser.getEndereco());
			user.setEmail(newUser.getEmail());
			user.setSenha(newUser.getSenha());
			return usuarioRepository.save(user);
		}).orElseThrow(() -> new UsuarioNotFoundException(id));

		return usuarioRepository.save(usuarioAtualizado);
	}

	// Deletar
	@DeleteMapping("delete/user/{id}")
	public void deletar(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
}
