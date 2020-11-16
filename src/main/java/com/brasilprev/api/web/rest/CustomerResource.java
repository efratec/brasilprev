package com.brasilprev.api.web.rest;

import com.brasilprev.api.dto.CustomerDTO;
import com.brasilprev.api.exception.customer.CustomerAlreadyExistsException;
import com.brasilprev.api.model.Customer;
import com.brasilprev.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getListAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), CREATED);
    }

    @GetMapping(value = "name")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable(value = "name") String name)  {
        return ok(customerService.findCustomerByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        return ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("{id}")
    public void deleteBeer(@PathVariable Long id) {
        customerService.delete(id);
    }

}
