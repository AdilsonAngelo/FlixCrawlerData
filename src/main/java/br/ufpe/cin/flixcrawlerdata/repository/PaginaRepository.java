package br.ufpe.cin.flixcrawlerdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpe.cin.flixcrawlerdata.DAO.Pagina;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {
	public Pagina findByUrl(String url);
	public List<Long> findIdByDominio(String domain);
}
