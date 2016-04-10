package com.jahra.controller;

import com.jahra.service.BlogService;
import com.jahra.service.TagService;
import com.jahra.service.UserService;
import com.jahra.service.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Артём on 05.02.2016.
 */
@Controller
@RequestMapping("/dashboard")
public class UserDashboardController {
    public static final String DASHBOARD_VIEW = "user/dashboard";
    public static final String CREATE_BLOG_VIEW = "user/createBlog";
    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @RequestMapping
    public String dashBoard(ModelMap model, Principal principal) {
        String view = DASHBOARD_VIEW;
        if (!isUserHasBlog(principal)) {
            view = "redirect:/dashboard/create";
        }
        model.addAttribute("blog", blogService.getCurrentUserBlog());
        model.addAttribute("articles", blogService.getCurrentUserArticles());
        //tagService.getPopularTags(new PageRequest(0, 3));
        return view;
    }

    @RequestMapping("/create")
    public String renderCreateBlogView(Principal principal) {
        String view = CREATE_BLOG_VIEW;
        if (isUserHasBlog(principal)) {
            view = "redirect:/dashboard";
        }
        return view;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBlog(@ModelAttribute BlogDTO blogDTO, Principal user) {
        blogService.saveBlog(user.getName(), blogDTO);
        return "redirect:/dashboard";
    }

    private boolean isUserHasBlog(Principal principal) {
        return userService.findByUsername(principal.getName()).getBlog() != null;
    }
}
