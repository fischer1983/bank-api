package com.bank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Conta {
	
	@Id
	private String numero;
	
	private String agencia;
	
	@Column(name = "limite_cheque_especial")
	private BigDecimal limiteChequeEspecial;
	
	@Column(name = "tipo_conta")
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@OneToOne
	@JoinColumn(name = "cpf_cnpj_pessoa")
	private Pessoa pessoa;
	
	@OneToOne
	@JoinColumn(name = "id_cartao_credito")
	private CartaoCredito cartaoCredito;
	

	public Conta() {
		super();
		this.limiteChequeEspecial = BigDecimal.ZERO;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public BigDecimal getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
