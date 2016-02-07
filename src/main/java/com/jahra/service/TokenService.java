package com.jahra.service;

/**
 * Created by Артём on 07.02.2016.
 */
public interface TokenService {
    boolean confirmRegistration(String token);
}
