package br.com.eits.meusprojetos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;

@Entity
@Audited
@DataTransferObject(javascript="Atividade")
public class Atividade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5394367729248855982L;

	/*
	 * Constructors
	 */
	public Atividade() {}
	
	public Atividade(Long id, String descricao, String responsavel) {
		this.id = id;
		this.descricao = descricao;
		this.responsavel = responsavel;
	}	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	private String responsavel;
	
	/*
	 * Attributes
	 */	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
}
