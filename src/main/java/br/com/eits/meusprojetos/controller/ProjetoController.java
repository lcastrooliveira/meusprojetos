package br.com.eits.meusprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.eits.meusprojetos.service.ProjetoService;
import br.com.eits.meusprojetos.service.UserService;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private UserService userService;
	
	
}
