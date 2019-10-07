package com.bank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bank.model.CartaoCredito;
import com.bank.repository.ICartaoCreditoRepository;

@Service
public class CartaoCreditoServiceImpl extends AbstractService<ICartaoCreditoRepository, CartaoCredito, Long> {

	public CartaoCredito buildCartaoCredito(BigDecimal limiteCartaoCredito) {
		
		CartaoCredito cartaoCredito = new CartaoCredito();
		cartaoCredito.setLimite(limiteCartaoCredito);

		return repository.save(cartaoCredito);
	}

}
