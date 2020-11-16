package com.brasilprev.api.model;

import com.brasilprev.api.model.enums.UserRoles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private Long idUser;
	private UserRoles role;
	private String email;
	private String password;
	private String name;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long id) {
		this.idUser = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.ORDINAL)
	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(idUser, user.idUser) &&
				role == user.role &&
				Objects.equals(email, user.email) &&
				Objects.equals(password, user.password) &&
				Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser, role, email, password, name);
	}

}
