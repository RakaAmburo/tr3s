package com.project.tres.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String firstName;
	private String lastName;
	@NotNull
	@Pattern(message = "error.field.email", regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	  @JoinTable(name = "persona_tag", joinColumns = {
	      @JoinColumn(name = "PERSONA_ID", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {
	          @JoinColumn(name = "TAG_ID", referencedColumnName = "id", nullable = false, updatable = false)})
	@RestResource(path = "libraryTag", rel="tag")
	private Set<PersonTag> tags;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<PersonTag> getTags() {
		return tags;
	}

	public void setTags(Set<PersonTag> tags) {
		this.tags = tags;
	}
}
