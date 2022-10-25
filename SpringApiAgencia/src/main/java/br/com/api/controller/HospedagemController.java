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

import br.com.api.model.Hospedagem;
import br.com.api.repository.HospedagemRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class HospedagemController {

	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	//Listar
	@GetMapping("/list/hospedagem")
	public List<Hospedagem> listar(){
		return hospedagemRepository.findAll();
	}
	
	//criar
	@PostMapping("/hospedagem/add")
	public Hospedagem adicionar(@RequestBody Hospedagem hospedagem) {
		return hospedagemRepository.save(hospedagem);
	}
	
	
//	//criar imagem
//		@PostMapping("/hospedagem/add")
//		public Hospedagem adicionar(Hospedagem hospedagem, @RequestParam("imagem") MultipartFile file) throws IOException {
//			
//			try {
//				hospedagem.setImagem(file.getBytes());
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			return hospedagemRepository.save(hospedagem);
//		}
	
	
	//Listar por id
	@GetMapping("/listar/hospedagem/{id}")
	Hospedagem listarporId(@PathVariable Long id) {
		return hospedagemRepository.findById(id)
				.orElseThrow(() -> new HospedagemNotFoundException(id));
	}
	
	//Atualizar
	@PutMapping("/hospedagem/update/{id}")
	Hospedagem atualizar(@RequestBody Hospedagem newHospedagem, @PathVariable Long id) {
		Hospedagem hospedagemAtualizada = hospedagemRepository.findById(id)
		 .map(host -> {
             host.setEmpresa(newHospedagem.getEmpresa());
             host.setEndereco(newHospedagem.getEndereco());
			 host.setData_hospedagem(newHospedagem.getData_hospedagem());
   		   	 host.setPreco_diaria(newHospedagem.getPreco_diaria());
   		   	 host.setImagem(newHospedagem.getImagem());
             return hospedagemRepository.save(host);
         }).orElseThrow(() -> new HospedagemNotFoundException(id)); 
		
		return hospedagemRepository.save(hospedagemAtualizada);
	}
	
	//Deletar
		@DeleteMapping("delete/hospedagem/{id}")
		public void deletar(@PathVariable Long id) {
			 hospedagemRepository.deleteById(id);
		}
}
