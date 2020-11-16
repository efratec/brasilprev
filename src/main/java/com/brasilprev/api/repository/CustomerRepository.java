package com.brasilprev.api.repository;

import com.brasilprev.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Boolean existsByNameAndCpf(String name, String cpf);

    Optional<Customer> findCustomerByName(String name);

}
