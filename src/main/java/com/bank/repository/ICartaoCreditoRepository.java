package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.CartaoCredito;

public interface ICartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

}
