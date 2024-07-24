package com.springboog.jpa.relationship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.springboog.jpa.relationship.entities.Client;
import com.springboog.jpa.relationship.entities.Invoice;
import com.springboog.jpa.relationship.repositories.ClientRepository;
import com.springboog.jpa.relationship.repositories.InvoiceRepository;

@SpringBootApplication
public class RelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository	invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findClientByIdmanyToOne();
	}

	@Transactional
	public void findClientByIdmanyToOne() {
		Optional<Client> optionalClient = clientRepository.findById(1L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.get();
			Invoice invoice = new Invoice("Compra Carro", 3000L);
			invoice.setClient(client);
			Invoice invoiceResult = invoiceRepository.save(invoice);
			System.out.println("INVOICE_RESULT => " + invoiceResult);
		} else {
			System.out.println("CLIENT NOT FOUND");
		}
	}

	@Transactional
	public void createClientAndInvoicemanyToOne() {
		Client client = new Client("Marlon", "Gonzalez");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compra de computadores", 200L);
		invoice.setClient(client);
		Invoice invoiceResult = invoiceRepository.save(invoice);
		System.out.println("INVOICE_RESULT => " + invoiceResult);
	}
}
