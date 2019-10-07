package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.Parametro;
import com.bank.repository.IParametroRepository;

@Service
public class ParametroServiceImpl extends AbstractService<IParametroRepository, Parametro, String>{
	
	private static final String AGENCIA = "AGENCIA";

	public String getAgencia() {
		return repository.findByChave(AGENCIA).getValor();
	}

}
