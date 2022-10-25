package br.com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

	// private FuncionarioRepositorio funcionarioRepositorio;
	
	@Autowired
	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	/*
	 * @GetMapping("/perfil") public ModelAndView perfil(Principal principal) {
	 * ModelAndView modelAndView = new ModelAndView("usuario/perfil");
	 * 
	 * Funcionario usuario =
	 * funcionarioRepositorio.findByEmail(principal.getName()).get();
	 * modelAndView.addObject("usuario", usuario);
	 * modelAndView.addObject("alterarSenhaForm", new AlterarSenhaDAO());
	 * 
	 * return modelAndView; }
	 * 
	 * @PostMapping("/alterar-senha") public String alterarSenha(AlterarSenhaDAO
	 * form, Principal principal) { Funcionario usuario =
	 * funcionarioRepositorio.findByEmail(principal.getName()).get();
	 * 
	 * if (SenhaUtils.matches(form.getSenhaAtual(), usuario.getSenha())) {
	 * usuario.setSenha(SenhaUtils.encode(form.getNovaSenha()));
	 * 
	 * funcionarioRepositorio.save(usuario); }
	 * 
	 * return "redirect:/perfil"; }
	 */

}
