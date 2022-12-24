package com.mc.gestionformation.integration.dao;

import java.util.Collection;
import java.util.Optional;

import com.mc.gestionformation.model.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	void deleteById(Long id);

	Optional<T> findById(Long id);

	Collection<T> findAll();

}
