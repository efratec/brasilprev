package com.brasilprev.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.brasilprev.api.constants.Constants.Messages.CPF_IS_A_REQUIRED_FIELD;
import static com.brasilprev.api.constants.Constants.Messages.NAME_IS_A_REQUIRED_FIELD;

public class CustomerDTO {

    private Long id;

    @NotNull(message = NAME_IS_A_REQUIRED_FIELD)
    @NotBlank(message = NAME_IS_A_REQUIRED_FIELD)
    private String name;

    @NotNull(message = CPF_IS_A_REQUIRED_FIELD)
    @NotBlank(message = NAME_IS_A_REQUIRED_FIELD)
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

}
