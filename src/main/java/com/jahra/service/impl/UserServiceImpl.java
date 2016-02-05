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
    public void saveUser(UserDTO user) {
        userRepository.save(UserDTO.toEntity(user));
    }
}
