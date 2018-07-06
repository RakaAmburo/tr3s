package com.project.tres.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	// problemas con el put (orphan) y con las validaciones en put
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinTable(name = "persona_tag", joinColumns = {
			@JoinColumn(name = "PERSONA_ID", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TAG_ID", referencedColumnName = "id", nullable = false, updatable = false) })
	// @RestResource(path = "libraryTag", rel = "tag")
	private Set<PersonTag> tags;

	@ManyToOne
	@JoinColumn(name = "country", insertable = false, updatable = false)
	private Country country;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@PrimaryKeyJoinColumn
	private PersonExt personExt;

	@Column(name = "country")
	@JsonIgnore
	private Integer countryId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Language> languages;


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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	public PersonExt getPersonExt() {
		return personExt;
	}

	public void setPersonExt(PersonExt personExt) {
		this.personExt = personExt;
	}
	
	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
}
