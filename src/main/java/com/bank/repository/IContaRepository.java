package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.model.Conta;

public interface IContaRepository extends JpaRepository<Conta, String> {

	final String SQL_GET_MIN_NUMERO_CONTA = "SELECT COALESCE(MAX(numero), 0) + 1 FROM Conta";

	@Query(value = SQL_GET_MIN_NUMERO_CONTA)
	Integer getMaxNumeroConta();

}
