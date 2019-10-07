package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.Pessoa;
import com.bank.model.TipoPessoa;
import com.bank.repository.IPessoaRepository;

@Service
public class PessoaServiceImpl extends AbstractService<IPessoaRepository, Pessoa, String> {
	
	public static final String DOCUMENTO_INVALIDO = "DOCUMENTO_INVALIDO";
	
	private Pessoa pessoa;
	
	public Pessoa buildPessoa(String documento, Integer score) throws Exception {
		
		pessoa = new Pessoa();
		
		pessoa.setCpfCnpj(documento);
		pessoa.setScore(score);
		
		if (isCpf(documento)) {
			pessoa.setTipoPessoa(TipoPessoa.PF);
		} else if (isCnpj(documento)) {
			pessoa.setTipoPessoa(TipoPessoa.PJ);
		} else {
			throw new Exception(DOCUMENTO_INVALIDO);
		}
		
		return save(pessoa);
	}

	private boolean isCnpj(String documento) {
		return documento != null && documento.length() == 14;
	}

	private boolean isCpf(String documento) {
		return documento != null && documento.length() == 11;
	}
	
}
