package com.jahra.service;

import com.jahra.model.Article;
import com.jahra.model.Blog;
import com.jahra.service.dto.BlogDTO;

import java.util.List;

/**
 * @author a.vorushenko
 */
public interface BlogService {
    void saveBlog(String username, BlogDTO blogDTO);
    Blog getCurrentUserBlog();
    List<Article> getCurrentUserArticles();
}
