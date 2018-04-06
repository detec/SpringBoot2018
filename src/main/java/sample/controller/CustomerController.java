package sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.domain.Customer;
import sample.repository.CustomerRepository;

/**
 * Endpoint for sample class {@link Customer}
 *
 * @author Andrii Duplyk
 *
 */
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

	@PostMapping
	ResponseEntity<Customer> saveCustomer(
            @RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.CREATED);

	}


	@PutMapping("{id}")
	ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer entity) {
		Customer newEntity = repository.save(entity);
		return new ResponseEntity<>(newEntity, HttpStatus.OK);
	}


	@GetMapping("{id}")
	ResponseEntity<Customer> getCustomerById(
            @PathVariable String id) {
        return repository.findById(Long.valueOf(id)).map(cust -> new ResponseEntity<>(cust, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@DeleteMapping("{id}")
    ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        Customer entity = repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));
        repository.delete(entity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/filter/{lastName}")
	ResponseEntity<List<Customer>> findByLastName(
            @PathVariable String lastName) {
        return new ResponseEntity<>(repository.findAllByLastName(lastName), HttpStatus.OK);
	}

    @GetMapping
    ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(repository.listAllCustomers(), HttpStatus.OK);
    }
}
