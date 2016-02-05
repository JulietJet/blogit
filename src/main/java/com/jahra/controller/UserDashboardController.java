package com.jahra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Артём on 05.02.2016.
 */
@Controller
@RequestMapping("/dashboard")
public class UserDashboardController {
    public static final String DASHBOARD_VIEW = "user/dashboard";

    @RequestMapping
    public String dashBoard(ModelMap model) {
        return DASHBOARD_VIEW;
    }
}
