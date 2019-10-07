package com.bank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.CartaoCredito;
import com.bank.model.Conta;
import com.bank.model.Pessoa;
import com.bank.model.TipoConta;
import com.bank.model.TipoPessoa;
import com.bank.repository.IContaRepository;

@Service
public class ContaServiceImpl extends AbstractService<IContaRepository, Conta, String> {
	
	@Autowired
	private ParametroServiceImpl parametroService;
	
	public Conta buildConta(Pessoa pessoa, CartaoCredito cartaoCredito, BigDecimal limiteChequeEspecial) throws Exception {
		
		Conta conta = new Conta();
		
		conta.setNumero(generateNumeroConta());
		conta.setAgencia(parametroService.getAgencia());
		conta.setPessoa(pessoa);
		conta.setLimiteChequeEspecial(limiteChequeEspecial);
		conta.setCartaoCredito(cartaoCredito);
		
		if (TipoPessoa.PF.equals(pessoa.getTipoPessoa())) {
			
			conta.setTipoConta(TipoConta.C);
			
		} else if (TipoPessoa.PJ.equals(pessoa.getTipoPessoa())) {
			
			conta.setTipoConta(TipoConta.E);
			
		} else {
			
			throw new Exception("TIPO_PESSOA_INVALIDO");
			
		}
		
		return repository.save(conta);
	}
	
	public String generateNumeroConta() {
		 
		 String numero = getMaxNumeroConta().toString();
		 
		 return leftPad(numero);
	}
	
	
	private Integer getMaxNumeroConta() {
		return repository.getMaxNumeroConta();
	}
	
	private String leftPad(String inputString) {
		
		final Integer MAX_LENGTH = 6;

		StringBuilder sb = new StringBuilder();
		for (int i = inputString.length(); i <= MAX_LENGTH; i++) {
			sb.append('0');
		}

		return sb.substring(inputString.length()) + inputString;
	}

}
