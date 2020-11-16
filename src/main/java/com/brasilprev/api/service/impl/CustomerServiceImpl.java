package com.brasilprev.api.service.impl;

import com.brasilprev.api.dto.CustomerDTO;
import com.brasilprev.api.exception.customer.CustomerAlreadyExistsException;
import com.brasilprev.api.model.Customer;
import com.brasilprev.api.repository.CustomerRepository;
import com.brasilprev.api.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.brasilprev.api.model.builder.CustomerBuilder.aCustomer;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) throws CustomerAlreadyExistsException {

        if (customerRepository.existsByNameAndCpf(customerDTO.getName(), customerDTO.getCpf())) {
            throw new CustomerAlreadyExistsException("Usuário já está cadastrado!");
        }

        return customerRepository.save(aCustomer()
                .withAddress(customerDTO.getAddress())
                .withName(customerDTO.getName())
                .withCpf(customerDTO.getCpf())
                .build());
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerToUpdate) {
        Customer customer = getCustomerById(id);
        copyProperties(customerToUpdate, customer, "id");
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getListAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(getCustomerById(id));
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name).orElse(null);
    }

    private Customer getCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

}
