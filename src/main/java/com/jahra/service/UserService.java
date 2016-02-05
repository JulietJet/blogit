package com.jahra.service;

import com.jahra.model.User;
import com.jahra.service.dto.UserDTO;

/**
 * Created by Артём on 01.02.2016.
 */
public interface UserService {
    void saveUser(UserDTO user);
    void changeUserStatus(Long id, boolean isEnabled);
    User getUserById(Long id);
}
