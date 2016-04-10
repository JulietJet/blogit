package com.jahra.controller;

import com.jahra.model.Article;
import com.jahra.service.ArticleService;
import com.jahra.service.BlogService;
import com.jahra.utils.ArticleTitleIsInvalidException;
import com.jahra.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author a.vorushenko
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService service;
    @Autowired
    BlogService blogService;

    @RequestMapping("/create")
    public String render(@RequestParam(value = "a", required = false) Long articleId, Model model) {
        if (articleId != null) {
            Article articleToEdit = service.findOne(articleId);
            if (!blogService.getCurrentUserBlog().getArticles().contains(articleToEdit)) {
                return "redirect:/dashboard";
            }
            model.addAttribute("article", articleToEdit);
            model.addAttribute("tags", ArticleUtils.getTagsWithSeparator(articleToEdit.getTags()));
        }
        return "article/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newArticle(@ModelAttribute("article") Article article, Model model) {

        if (article.getTags().size() > 5) {
            return "article/create";
        }
        article.setBlog(blogService.getCurrentUserBlog());
        try {
            Article savedArticle = service.newArticle(article);
        } catch (ArticleTitleIsInvalidException e) {
            model.addAttribute("article", article);
            model.addAttribute("tags", ArticleUtils.getTagsWithSeparator(article.getTags()));
            model.addAttribute("status", "error");
        }
        return "redirect:/dashboard";
    }
}
