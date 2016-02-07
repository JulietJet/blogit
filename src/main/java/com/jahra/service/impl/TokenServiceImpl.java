package com.jahra.service.impl;

import com.jahra.model.Token;
import com.jahra.repository.TokenRepository;
import com.jahra.service.TokenService;
import com.jahra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author a.vorushenko
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserService userService;

    @Override
    @Transactional
    public boolean confirmRegistration(String token) {
        Token tok = tokenRepository.findByToken(token);
        if (tok != null) {
            userService.changeUserStatus(tok.getUser().getId(), true);
            tokenRepository.delete(tok);
            return true;
        } else {
            return false;
        }
    }
}
