package local.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Unidade;
import local.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private UnidadeRepository unidadeDAO;
	
	@GetMapping
	public List<Unidade> listar(){
		return unidadeDAO.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Unidade> salvar(@RequestBody Unidade unidade, HttpServletResponse response) {
		Unidade uc = unidadeDAO.save(unidade);
		return new ResponseEntity<Unidade>(uc, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public Unidade buscar (@PathVariable int id) {
		return unidadeDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Unidade uc = unidadeDAO.findById(id).get();
		unidadeDAO.delete(uc);
	}

	/**
	@PostConstruct
	public void popularDB() {
		Unidade uc1 = new Unidade();
		uc1.setNome("Algoritmos III");
		Unidade uc2 = new Unidade();
		uc2.setNome("Algoritmos I");
		unidadeDAO.saveAll(Arrays.asList(uc1,uc2));
	}
	*/
}
