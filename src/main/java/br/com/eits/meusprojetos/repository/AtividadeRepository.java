package br.com.eits.meusprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eits.meusprojetos.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {}
