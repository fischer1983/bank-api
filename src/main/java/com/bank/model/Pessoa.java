package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name = "tipo_pessoa")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	private Integer score;
	

	public Pessoa() {
		super();
		this.score = 0;
	}
	

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
