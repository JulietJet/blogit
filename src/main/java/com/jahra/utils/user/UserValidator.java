package com.jahra.utils.user;

import com.jahra.service.dto.UserDTO;
import com.jahra.utils.RegexConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артём on 05.02.2016.
 */
public final class UserValidator {



    private UserValidator(){

    }

    public static boolean isValidUserInfo(UserDTO userDTO) {
        return isValidUsername(userDTO.getUsername()) && isValidEmail(userDTO.getEmail())
                && isValidPassword(userDTO.getPassword());
    }

    private static boolean isValidEmail(String email) {
        return checkWithRegex(email, RegexConstants.EMAIL_PATTERN);
    }

    private static boolean isValidUsername(String username) {
        return checkWithRegex(username, RegexConstants.USERNMAME_PATTERN);
    }

    private static boolean isValidPassword(String username) {
        return username.length() > 6 && username.length() < 30;
    }

    private static boolean checkWithRegex(String value, String regex) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
