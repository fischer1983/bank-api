package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Parametro;

public interface IParametroRepository extends JpaRepository<Parametro, String>{
	
	Parametro findByChave(String chave);

}
