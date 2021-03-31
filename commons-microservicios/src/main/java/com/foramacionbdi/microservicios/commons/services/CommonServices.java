package com.foramacionbdi.microservicios.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface CommonServices<E> {
	
	public Iterable<E> findAll();
	
	public Page<E> findAll(Pageable pageable); // iterable por rangos 
	
	public Optional<E> findById(Long id);
	public E save(E entity);
	public void deleteById(Long Id);
	

}
