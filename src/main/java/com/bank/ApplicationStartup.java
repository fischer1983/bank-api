package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.bank.facade.OpenContaFacadeImpl;
import com.bank.model.Conta;
import com.bank.model.Pessoa;
import com.bank.service.PessoaServiceImpl;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	private Pessoa pessoaPfScore0And1;
	
	private Pessoa pessoaPjScore2And5;
	
	private Pessoa pessoaPfScore6And8;
	
	private Pessoa pessoaPjScore9;
	
	@Autowired 
	private PessoaServiceImpl pessoaService;
	
	@Autowired
	private OpenContaFacadeImpl openContaFacade;
	

	@SuppressWarnings("unused")
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		try {
			pessoaPfScore0And1 = pessoaService.buildPessoa("07602106083", 1);
			
			pessoaPjScore2And5 = pessoaService.buildPessoa("69496952000144", 4);
			
			pessoaPfScore6And8 = pessoaService.buildPessoa("59569212004", 8);
			
			pessoaPjScore9 = pessoaService.buildPessoa("39570143000174", 9);
			
			
			Conta contaPfScore0And1 = openContaFacade.execute(pessoaPfScore0And1);
			
			Conta contaPfScore2And5 = openContaFacade.execute(pessoaPjScore2And5);
			
			Conta contaPfScore6And8 = openContaFacade.execute(pessoaPfScore6And8);
			
			Conta contaPjScore9 = openContaFacade.execute(pessoaPjScore9);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
