package br.ufpe.cin.flixcrawlerdata.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(params = {"id"})
	public Pagina getPaginaById(@RequestParam("id") Long id) {
		return this.ps.getById(id);
	}


	@GetMapping(params = {"url"})
	public Pagina getPaginaByUrl(@RequestParam("url") String url) throws UnsupportedEncodingException {
		return this.ps.getByUrl(URLDecoder.decode(url, "UTF-8"));
	}

	@GetMapping("/count")
	public Long getPaginaCount(){
		return this.ps.count();
	}

	@DeleteMapping("/delete/{id}")
	public Pagina deletePagina(@PathVariable long id) {
		return this.ps.delete(id);
	}

	@GetMapping("/domain-ids/{domain}")
	public List<Long> getByDomain(@PathVariable String domain) throws UnsupportedEncodingException{
		return this.ps.getIdsByDomain(URLDecoder.decode(domain, "UTF-8"));
	}

}