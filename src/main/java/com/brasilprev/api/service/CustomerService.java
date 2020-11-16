package com.brasilprev.api.service;

import com.brasilprev.api.dto.CustomerDTO;
import com.brasilprev.api.exception.customer.CustomerAlreadyExistsException;
import com.brasilprev.api.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExistsException;

    List<Customer> getListAllCustomers();

    void delete(Long id);

    Customer findCustomerByName(String name);

    Customer updateCustomer(Long id, Customer customerToUpdate);
}
