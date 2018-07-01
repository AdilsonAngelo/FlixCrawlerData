package br.ufpe.cin.flixcrawlerdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpe.cin.flixcrawlerdata.DAO.Pagina;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {
	public Pagina findByUrl(String url);
}
