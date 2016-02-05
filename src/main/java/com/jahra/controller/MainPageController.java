package com.jahra.controller;

import com.jahra.repository.UserRepository;
import com.jahra.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Артём on 05.02.2016.
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @Autowired
    UserRepository userService;
    @RequestMapping
    public String mainPage(ModelMap model) {
        model.addAttribute("user", new UserDTO());
        return "site/mainPage";
    }

}
