package com.brasilprev.api.dto;

import com.brasilprev.api.model.enums.UserRoles;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDTO {

    private Long idUser;

    @NotNull(message = "A valid role is mandatory [ADMIN, USER]")
    private UserRoles role;

    @NotBlank(message = "The email is mandatory")
    private String email;

    @NotBlank(message = "The password is mandatory")
    private String password;

    @NotBlank(message = "The name is mandatory")
    private String name;

    public UserDTO() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
