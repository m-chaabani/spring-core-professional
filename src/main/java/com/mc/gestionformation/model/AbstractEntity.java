package com.mc.gestionformation.model;

import java.time.LocalDate;

public abstract class AbstractEntity {


	protected Long id;
	protected String version;
	protected LocalDate createdAt;
	protected LocalDate modifiedAt;

	public AbstractEntity() {

	}

	public AbstractEntity(Long id, String version, LocalDate createdAt, LocalDate modifiedAt) {
		super();
		this.id = id;
		this.version = version;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDate modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
