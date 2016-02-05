package com.jahra.service.impl;

import com.jahra.model.User;
import com.jahra.repository.UserRepository;
import com.jahra.service.UserService;
import com.jahra.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Артём on 01.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void changeUserStatus(Long id, boolean isEnabled) {
        userRepository.changeUserStatus(id, isEnabled);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserDTO registerUser(UserDTO user) {
        User newUser = UserDTO.toEntity(user);
        userRepository.save(newUser);
//        UserRole role = new UserRole();
//        role.setRole("USER");
        return UserDTO.fromEntity(newUser);
    }

    @Override
    public boolean isUserAlreadyExists(String userName, String email) {
        return userRepository.isUserAlreadyExists(userName, email);
    }
}
