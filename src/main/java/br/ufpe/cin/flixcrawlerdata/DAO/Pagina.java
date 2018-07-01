package br.ufpe.cin.flixcrawlerdata.DAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pagina", uniqueConstraints = @UniqueConstraint(columnNames = {"url"}))
public class Pagina implements Serializable {

	private static final long serialVersionUID = -1373207253083103519L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "url")
	private String url;

	@Column(name = "texto")
	private String texto;

	@Column(name = "dominio")
	private String dominio;

	@Column(name = "data_captacao")
	private long dataCaptacao;

	@Column(name = "data_atualizacao")
	private long dataAtualizacao;

	@Column(name = "score")
	private int score;

	protected Pagina () {}

	public Pagina(String url, String texto, long dataCaptacao, long dataAtualizacao, int score) {
		this.url = url;
		this.texto = texto;
		this.dataCaptacao = dataCaptacao;
		this.dataAtualizacao = dataAtualizacao;
		this.score = score;
	}

	public String toString() { return dominio; }

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public String getTexto() { return texto; }

	public void setTexto(String texto) { this.texto = texto; }

	public String getDominio() { return dominio; }
	
	public void setDominio(String dominio) { this.dominio = dominio; }

	public long getDataCaptacao() { return dataCaptacao; }

	public void setDataCaptacao(long dataCaptacao) { this.dataCaptacao = dataCaptacao; }

	public long getDataAtualizacao() { return dataAtualizacao; }

	public void setDataAtualizacao(long dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

	public int getScore() { return score; }

	public void setScore(int score) { this.score = score; }
}
