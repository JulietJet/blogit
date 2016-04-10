package com.jahra.service.dto;

import com.jahra.model.User;
import com.jahra.utils.RegexConstants;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

;

/**
 * Created by Артём on 01.02.2016.
 */
public class UserDTO {
    private Long id;

    @NotNull
    @Pattern(regexp = RegexConstants.USERNMAME_PATTERN)
    private String username;

    @Size(min = 6, max = 30)
    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;
    private boolean isUserEnabled;

    public boolean isUserEnabled() {
        return isUserEnabled;
    }

    public void setUserEnabled(boolean userEnabled) {
        isUserEnabled = userEnabled;
    }

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
        user.setUserEnabled(dto.isUserEnabled());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        return user;
    }

    public static UserDTO fromEntity(User user) {
        UserDTO userDto = new UserDTO();
        if (user == null) {
            return userDto;
        }
        userDto.setUserEnabled(user.isUserEnabled());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        return userDto;
    }
}
