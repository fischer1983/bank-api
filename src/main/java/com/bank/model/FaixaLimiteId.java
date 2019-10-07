package com.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FaixaLimiteId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "score_min")
	private Integer scoreMin;
	
	@Column(name = "score_max")
	private Integer scoreMax;

	
	public Integer getScoreMin() {
		return scoreMin;
	}

	public void setScoreMin(Integer scoreMin) {
		this.scoreMin = scoreMin;
	}

	public Integer getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(Integer scoreMax) {
		this.scoreMax = scoreMax;
	}

}
