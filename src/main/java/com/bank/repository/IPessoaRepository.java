package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Pessoa;

public interface IPessoaRepository extends JpaRepository<Pessoa, String> {

}
