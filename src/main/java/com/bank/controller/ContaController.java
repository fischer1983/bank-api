package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Conta;
import com.bank.service.ContaServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaServiceImpl contaService;
	
	@GetMapping
	public List<Conta> findAll() {
		return contaService.findAll();
	}

}
