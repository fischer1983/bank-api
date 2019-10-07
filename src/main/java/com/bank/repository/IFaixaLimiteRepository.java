package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.model.FaixaLimite;
import com.bank.model.FaixaLimiteId;

public interface IFaixaLimiteRepository extends JpaRepository<FaixaLimite, FaixaLimiteId>{
	
	@Query(value = "SELECT f FROM FaixaLimite f WHERE :score BETWEEN f.id.scoreMin and f.id.scoreMax ")
	FaixaLimite findBetweenScoreMinScoreMax(@Param("score") Integer score);

}
