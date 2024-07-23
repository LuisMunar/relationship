package com.springboog.jpa.relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboog.jpa.relationship.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {}
