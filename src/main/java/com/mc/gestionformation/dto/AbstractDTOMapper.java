package com.mc.gestionformation.dto;

import com.mc.gestionformation.model.AbstractEntity;

public interface AbstractDTOMapper<D extends AbstractDTO, E extends AbstractEntity> {

	E dtoToEntity(D d);

	D entityToDto(E e);
}
