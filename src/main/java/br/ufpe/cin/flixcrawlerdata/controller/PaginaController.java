package br.ufpe.cin.flixcrawlerdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.cin.flixcrawlerdata.DAO.Pagina;
import br.ufpe.cin.flixcrawlerdata.service.PaginaService;

@RestController
@RequestMapping("/pagina")
public class PaginaController  {
	
	@Autowired
	private PaginaService ps;
	
	@PostMapping("/new")
	public Pagina savePagina(@RequestBody Pagina pagina) {
		return this.ps.create(pagina);
	}

	@GetMapping("/id/{id}")
	public Pagina getPagina(@PathVariable long id) {
		return this.ps.getById(id);
	}
	
	@GetMapping("/url/{url}")
	public Pagina getPaginaUrl(@PathVariable String url) {
		return this.ps.getByUrl(url);
	}
	
	@GetMapping("/count")
	public Long getPaginaCount(){
		return this.ps.count();
	}
	
	@DeleteMapping("/{id}")
	public Pagina deletePagina(@PathVariable long id) {
		return this.ps.delete(id);
	}
	
}