package com.jahra.service;

import com.jahra.model.User;
import com.jahra.service.dto.UserDTO;

/**
 * Created by Артём on 01.02.2016.
 */
public interface UserService {
    UserDTO registerUser(UserDTO user);
    void changeUserStatus(Long id, boolean isEnabled);
    User getUserById(Long id);
    boolean isUserAlreadyExists(String userName, String email);
    User findByUsername(String username);
}
