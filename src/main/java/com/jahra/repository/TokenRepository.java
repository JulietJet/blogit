package com.jahra.repository;

import com.jahra.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Артём on 07.02.2016.
 */
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
