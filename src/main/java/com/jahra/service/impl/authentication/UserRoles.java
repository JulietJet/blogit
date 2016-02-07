package com.jahra.service.impl.authentication;

/**
 * Created by Артём on 06.02.2016.
 */
public enum UserRoles {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    ANONYMOUS("ROLE_ANONYMOUS");

    UserRoles(String role) {
        this.role = role;
    }

    private String role;

    public String getRole() {
        return role;
    }
}
