package com.mc.gestionformation.integration.dao;

import com.mc.gestionformation.dto.AbstractDTO;

public interface IDAO<T extends AbstractDTO> {

	T create(T dto);

	T update(T dto);

	T delete(T dto);

	T deleteById(Long id);

	T findById(Long id);

	T findAll();

}
