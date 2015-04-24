package br.com.eits.meusprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eits.meusprojetos.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {}
