package com.jahra.service.impl;

import com.jahra.model.Token;
import com.jahra.model.User;
import com.jahra.repository.TokenRepository;
import com.jahra.repository.UserRepository;
import com.jahra.service.UserService;
import com.jahra.service.dto.UserDTO;
import com.jahra.service.impl.authentication.UserRoles;
import com.jahra.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Артём on 01.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

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
        newUser.setUserRole(UserRoles.USER.getRole());
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        Token token = new Token();
        SecureRandom random = new SecureRandom();
        String key = new BigInteger(130, random).toString(32);
        token.setToken(key);
        token.setUser(newUser);
        tokenRepository.save(token);
        EmailUtils.sendEmail(token);
        return UserDTO.fromEntity(newUser);
    }

    @Override
    public boolean isUserAlreadyExists(String userName, String email) {
        return userRepository.isUserAlreadyExists(userName, email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
