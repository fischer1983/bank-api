package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<R extends JpaRepository<T, ID>, T, ID> {
	
	@Autowired
	protected R repository;
	
	public T save(T entity) {
		return repository.save(entity);
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}

}
