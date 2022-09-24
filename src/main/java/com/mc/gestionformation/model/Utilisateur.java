package com.mc.gestionformation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Utilisateur extends AbstractEntity {

	private String username;
	private String password;
	private String email;

	@Transient
	private Set<Role> roles = new HashSet<>();

	public Utilisateur() {

	}

	public Utilisateur(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
