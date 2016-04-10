package com.jahra.controller;

import com.jahra.model.Article;
import com.jahra.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author a.vorushenko
 */
@Controller
@RequestMapping("/")
public class UserArticlesViewController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("view/{blog}/{article}")
    public String showArticle(@PathVariable("blog") String blog,
                              @PathVariable("article") String title, Model model) {
        Article article = articleService.findByUrl(blog + "/" + title);
        model.addAttribute("article", article);
        return article == null ? "404" : "article/view";
    }
}
