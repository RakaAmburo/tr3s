package com.project.tres.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "languages")
@JsonView(ViewProfiles.Public.class)
public class Language implements Serializable {

  private static final long serialVersionUID = 7749173631203608632L;
  private Long id;
  private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", length = 30, updatable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



}
