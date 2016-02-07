package com.jahra.utils;

import com.jahra.model.Token;
import org.apache.commons.mail.*;

/**
 * @author a.vorushenko
 */
public final class EmailUtils {
    public static void sendEmail(Token token) {
        try {
            constructEmail(token).send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    private static ImageHtmlEmail constructEmail(Token token) {
        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setHostName("smtp.mail.yahoo.com");
        email.setSmtpPort(587);
        //TODO move settings to admin panel
        email.setAuthenticator(new DefaultAuthenticator("blogit.registration", "qwertyzxcvb"));
        email.setStartTLSEnabled(true);
        try {
            email.setFrom("blogit.registration@yahoo.com");
            email.setSubject("Confirm your registration");
            email.setHtmlMsg(constructMailText(token));
            email.addTo(token.getUser().getEmail());
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return email;
    }

    private static String constructMailText(Token token) {
        return "Dear " + token.getUser().getUsername()
                + ". Welcom to BlogIt! Please, confirm your registration (follow the link bellow) <br>"
                + "<a href='" + constructVerificationUrl(token) + "'>Confirm your registration!</a>";
    }

    private static String constructVerificationUrl(Token token) {
        return "http://localhost:8088/registration/confirm/" + token.getToken();
    }
}
