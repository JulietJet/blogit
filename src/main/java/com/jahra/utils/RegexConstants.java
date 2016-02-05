package com.jahra.utils;

/**
 * Created by Артём on 05.02.2016.
 */
public final class RegexConstants {
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String USERNMAME_PATTERN = "^[a-zA-Z0-9]{2,15}+$";
}
