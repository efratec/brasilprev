package com.brasilprev.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

import static com.brasilprev.api.constants.Constants.Messages.CPF_IS_A_REQUIRED_FIELD;
import static com.brasilprev.api.constants.Constants.Messages.NAME_IS_A_REQUIRED_FIELD;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = NAME_IS_A_REQUIRED_FIELD)
    private String name;

    @NotNull(message = CPF_IS_A_REQUIRED_FIELD)
    private String cpf;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(cpf, customer.cpf) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, address);
    }

}
