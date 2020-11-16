package com.brasilprev.api.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserRoles {

    ADMIN("ADMIN"),
	USER("USER");

    private final String description;

    UserRoles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

	@JsonCreator
	public static UserRoles fromString(String string) {
		UserRoles role;
		try {
			role = UserRoles.valueOf(string);
		} catch (Exception e) {
			role = null;
		}
		return role;
	}

}
