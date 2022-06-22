package com.mc.gestionformation.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.mc.gestionformation.dto.AbstractDTO;
import com.mc.gestionformation.integration.dao.IDAO;
import com.mc.gestionformation.model.AbstractEntity;

public abstract class AbstractCRUDBusiness<D extends AbstractDTO> {

	abstract IDAO getRepo();

	public D create(D dto) {
		dto.setEntity(getRepo().create(dto.getEntity()));
		return dto;
	}

	public D update(D dto) {
		dto.setEntity(getRepo().update(dto.getEntity()));
		return dto;
	}

	public boolean delete(D dto) {
		return getRepo().delete(dto.getEntity());
	}

	public D findById(D dto) {
		Optional<AbstractEntity> opt = getRepo().findById(dto.getEntity().getId());
		AbstractEntity entity = opt.isPresent() ? opt.get() : null;
		dto.setEntity(entity);
		return dto;
	}

	public D findAll(D dto) {
		if (dto == null)
			throw new IllegalArgumentException("le DTO ne peut pas etre null");
		Collection<AbstractEntity> listeEntities = getRepo().findAll();
		dto.setListEntity(new ArrayList(listeEntities));
		return dto;
	}

}
