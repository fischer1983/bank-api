package com.bank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "faixa_limite")
public class FaixaLimite {
	
	@EmbeddedId
	private FaixaLimiteId id;
	
	@Column(name = "limite_cheque_especial")
	private BigDecimal limiteChequeEspecial;
	
	@Column(name = "limite_cartao_credito")
	private BigDecimal limiteCartaoCredito;
	

	public FaixaLimiteId getId() {
		return id;
	}

	public void setId(FaixaLimiteId id) {
		this.id = id;
	}

	public BigDecimal getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public BigDecimal getLimiteCartaoCredito() {
		return limiteCartaoCredito;
	}

	public void setLimiteCartaoCredito(BigDecimal limiteCartaoCredito) {
		this.limiteCartaoCredito = limiteCartaoCredito;
	}
	
	public Integer getScoreMin() {
		return id != null ? id.getScoreMin() : null;
	}
	
	public Integer getScoreMax() {
		return id != null ? id.getScoreMax() : null;
	}	

}
