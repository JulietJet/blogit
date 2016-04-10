package com.jahra.controller;

import com.jahra.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author a.vorushenko
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(value = "find/{tag}", method = RequestMethod.GET)
    public String getListOfArticlesByTag(@PathVariable("tag") String tagName, Model model) {
        model.addAttribute("articles", tagService.findByName(tagName).getArticles());
        model.addAttribute("tag", tagName);
        return "article/list";
    }

}
