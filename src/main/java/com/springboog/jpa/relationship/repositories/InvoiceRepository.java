package com.springboog.jpa.relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboog.jpa.relationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {}
