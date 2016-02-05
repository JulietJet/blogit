package com.jahra.controller;

import com.jahra.model.Article;
import com.jahra.service.UserService;
import com.jahra.service.dto.ArticleDTO;
import com.jahra.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author a.vorushenko
 */

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String view(){
        return "user/create";
    }

    @RequestMapping(value = "/blog/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("article") ArticleDTO dto) {
        dto.setCreationDate(new Date());
        Article article = ArticleDTO.toEntity(dto);
        return "article/edit";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") UserDTO dto) {
        userService.saveUser(dto);
        return "user/create";
    }

}
