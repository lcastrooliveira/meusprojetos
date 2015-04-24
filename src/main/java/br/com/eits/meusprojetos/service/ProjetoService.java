package br.com.eits.meusprojetos.service;

import java.util.List;

import br.com.eits.meusprojetos.model.Projeto;

public interface ProjetoService {

	public abstract Projeto add(Projeto projeto);

	public abstract Projeto edit(Projeto projeto);

	public abstract void remove(Long id);

	public abstract List<Projeto> findAll();

	public abstract Projeto findById(Long id);

}