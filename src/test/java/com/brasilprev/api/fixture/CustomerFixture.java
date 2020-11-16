package com.brasilprev.api.fixture;

import com.brasilprev.api.model.Customer;

import static com.brasilprev.api.model.builder.CustomerBuilder.aCustomer;

public class CustomerFixture {

    public static Customer aCustomerMariaDaSilva() {
        return aCustomer()
                .withId(1L)
                .withCpf("08477925536")
                .withName("MARIA DA SILVA")
                .withAddress("RUA DA SILVA, Nº 10")
                .build();
    }

    public static Customer aCustomerCalMoreiraDaSilva() {
        return aCustomer()
                .withId(1L)
                .withCpf("555884499")
                .withName("Cal Moreira")
                .withAddress("RUA DA SILVA, Nº 10")
                .build();
    }

}
