package com.jahra.controller;

import com.jahra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Артём on 05.02.2016.
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @Autowired
    UserRepository userService;
    @RequestMapping
    public String mainPage(ModelMap model, Principal principal) {
        if (principal != null) {
            return "redirect:/dashboard";
        }
        return "site/mainPage";
    }

}
