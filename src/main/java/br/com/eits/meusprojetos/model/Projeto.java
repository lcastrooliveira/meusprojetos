package br.com.eits.meusprojetos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

@Entity
@Audited
@DataTransferObject(javascript="Projeto")
public class Projeto implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3258791227360209459L;

	/*
	 * Constructors
	 */
	
	public Projeto() {}
	
	public Projeto(Long id) {
		this.id = id;
	}
	
	public Projeto(Long id, String nomeProjeto, String responsavel) {
		this.id = id;
		this.nomeProjeto = nomeProjeto;
		this.responsavel = responsavel;
	}	
	
	/*
	 * Attributes
	 */
	
	@Id
	@GeneratedValue	
	private Long id;
	
	private String nomeProjeto;
	
	private String responsavel;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Atividade> atividade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}
}
