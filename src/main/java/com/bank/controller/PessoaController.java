package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Pessoa;
import com.bank.service.PessoaServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	@GetMapping
	public List<Pessoa> findAll() {
		return pessoaService.findAll();
	}

}
