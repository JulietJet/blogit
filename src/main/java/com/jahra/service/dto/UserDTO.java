package com.jahra.service.dto;

import com.jahra.model.User;

/**
 * Created by Артём on 01.02.2016.
 */
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        if (dto == null) {
            return user;
        }
        user.setUserEnabled(false);
        user.setUsername(dto.getPassword());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        return user;
    }
}
