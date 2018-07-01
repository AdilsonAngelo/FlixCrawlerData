package br.ufpe.cin.flixcrawlerdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpe.cin.flixcrawlerdata.DAO.Pagina;
import br.ufpe.cin.flixcrawlerdata.repository.PaginaRepository;

@Service
public class PaginaService {

	@Autowired
	private PaginaRepository pr;

	public synchronized Pagina create(Pagina p) {
		return this.pr.save(p);
	}

	public synchronized Pagina getById(Long id) {
		return this.pr.findById(id).get();
	}

	public synchronized Pagina getByUrl(String url) {
		return this.pr.findByUrl(url);
	}

	public synchronized Pagina delete(Long id) {
		Optional<Pagina> retorno = this.pr.findById(id);
		this.pr.deleteById(id);
		return retorno.get();
	}

	public synchronized Long count() {
		return this.pr.count();
	}

	public List<Long> getIdsByDomain(String domain) {
		return this.pr.findIdByDominio(domain);
	}

}
