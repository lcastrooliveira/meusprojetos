package br.com.eits.meusprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eits.meusprojetos.model.User;

public interface UserRepository extends JpaRepository<User, String> {}
