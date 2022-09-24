package com.mc.gestionformation.business;

import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.AbstractDTO;

@Transactional
public interface ICRUDBusiness<D extends AbstractDTO> {
	
	public D create(D dto) ;

	public D update(D dto) ;

	public boolean delete(D dto);

	public D findById(D dto) ;

	public D findAll(D dto) ;
}
