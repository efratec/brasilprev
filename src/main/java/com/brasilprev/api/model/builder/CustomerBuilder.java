package com.brasilprev.api.model.builder;

import com.brasilprev.api.model.Customer;

public class CustomerBuilder implements Builder<Customer> {

    private Customer customer = new Customer();

    private CustomerBuilder() {
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(Long id) {
        this.customer.setId(id);
        return this;
    }

    public CustomerBuilder withName(String name) {
        this.customer.setName(name);
        return this;
    }

    public CustomerBuilder withCpf(String cpf) {
        this.customer.setCpf(cpf);
        return this;
    }

    public CustomerBuilder withAddress(String address) {
        this.customer.setAddress(address);
        return this;
    }

    @Override
    public Customer build() {
        return this.customer;
    }

}
