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

import br.com.api.model.Passagem;
import br.com.api.repository.PassagemRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class PassagemController {

	@Autowired
	private PassagemRepository passagemRepository;
	
	//Listar
	@GetMapping("/list/passagem")
	public List<Passagem> listar(){
		return passagemRepository.findAll();
	}
	
	//criar
	@PostMapping("/passagem/add")
	public Passagem adicionar(@RequestBody Passagem passagem) {
		return passagemRepository.save(passagem);
	}
		
	//Listar por id
	@GetMapping("/listar/passagem/{id}")
	Passagem listarporId(@PathVariable Long id) {
		return passagemRepository.findById(id)
				.orElseThrow(() -> new PassagemNotFoundException(id));
	}
	
	//Atualizar
	@PutMapping("passagem/update/{id}")
	Passagem atualizar(@RequestBody Passagem newPassagem, @PathVariable Long id) {
		Passagem atorAtualizado = passagemRepository.findById(id)
		 .map(pass -> {
             pass.setData_passagem(newPassagem.getData_passagem());
             pass.setEmbarque(newPassagem.getEmbarque());
             pass.setDesembarque(newPassagem.getDesembarque());
             pass.setEmpresa(newPassagem.getEmpresa());
             pass.setValor_passagem(newPassagem.getValor_passagem());
             return passagemRepository.save(pass);
         }).orElseThrow(() -> new PassagemNotFoundException(id)); 
		
		return passagemRepository.save(atorAtualizado);
	}
	
	//Deletar
		@DeleteMapping("delete/passagem/{id}")
		public void deletar(@PathVariable Long id) {
			 passagemRepository.deleteById(id);
		}
}
