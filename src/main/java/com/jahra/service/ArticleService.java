package com.jahra.service;

import com.jahra.model.Article;
import com.jahra.utils.ArticleTitleIsInvalidException;

/**
 * @author a.vorushenko
 */
public interface ArticleService {
    Article newArticle(Article newArticle) throws ArticleTitleIsInvalidException;
    Article findOne(Long id);
    Article findByUrl(String url);
    void deleteArticle(Long id);
}
