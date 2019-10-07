package com.bank.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.CartaoCredito;
import com.bank.model.Conta;
import com.bank.model.FaixaLimite;
import com.bank.model.Pessoa;
import com.bank.service.CartaoCreditoServiceImpl;
import com.bank.service.ContaServiceImpl;
import com.bank.service.FaixaLimiteServiceImpl;
import com.bank.service.PessoaServiceImpl;

@Service
public class OpenContaFacadeImpl {
	
	private Pessoa pessoa;
	private FaixaLimite faixaLimite;
	private CartaoCredito cartaoCredito;
	
	@Autowired
	private ContaServiceImpl contaService;
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	@Autowired
	private FaixaLimiteServiceImpl faixaLimiteService;
	
	@Autowired
	private CartaoCreditoServiceImpl cartaoCreditoService;
	
	public Conta execute(Pessoa pessoa) throws Exception {
		
		return execute(pessoa.getCpfCnpj(), pessoa.getScore());
		
	}
	
	
	public Conta execute(String documento, Integer score) throws Exception {
		
		cartaoCredito = null;
		
		pessoa = pessoaService.buildPessoa(documento, score);
		
		faixaLimite = faixaLimiteService.findBetweenScoreMinScoreMax(score);
		
		if (score.compareTo(1) > 0) {
			cartaoCredito = cartaoCreditoService.buildCartaoCredito(faixaLimite.getLimiteCartaoCredito());
		}
		
		return contaService.buildConta(pessoa, cartaoCredito, faixaLimite != null ? faixaLimite.getLimiteChequeEspecial() : null);
	}

}
