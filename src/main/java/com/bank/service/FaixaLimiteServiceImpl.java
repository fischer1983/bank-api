package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.FaixaLimite;
import com.bank.model.FaixaLimiteId;
import com.bank.repository.IFaixaLimiteRepository;

@Service
public class FaixaLimiteServiceImpl extends AbstractService<IFaixaLimiteRepository, FaixaLimite, FaixaLimiteId> {
	
	public FaixaLimite findBetweenScoreMinScoreMax(Integer score) {
		return repository.findBetweenScoreMinScoreMax(score);
	}

}
