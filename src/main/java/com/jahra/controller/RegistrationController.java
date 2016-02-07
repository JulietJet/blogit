package com.jahra.controller;

import com.jahra.service.UserService;
import com.jahra.service.dto.UserDTO;
import com.jahra.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author a.vorushenko
 */

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final String VIEW_NAME = "registration/registrationForm";
    private static final String CONFIRM_VIEW_NAME = "registration/confirm";
    private static final String STATUS = "status";
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @RequestMapping(method = RequestMethod.GET)
    public String registrationForm(ModelMap model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return VIEW_NAME;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user") UserDTO userDTO, ModelMap model,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return VIEW_NAME;
        }
        if (userService.isUserAlreadyExists(userDTO.getUsername(), userDTO.getEmail())) {
            model.addAttribute(STATUS, "User already exists");
            return VIEW_NAME;
        }
        userService.registerUser(userDTO);
        return "registration/successRegistration";
    }

    @RequestMapping("/confirm/{token}")
    public String confirmUserRegistration(@PathVariable("token") String token, ModelMap model) {
        boolean isConfirmed = tokenService.confirmRegistration(token);
        model.addAttribute("isConfirmed", isConfirmed);
        return CONFIRM_VIEW_NAME;
    }
}
