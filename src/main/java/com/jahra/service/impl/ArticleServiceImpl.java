package com.jahra.service.impl;

import com.jahra.model.Article;
import com.jahra.model.Tag;
import com.jahra.repository.ArticleRepository;
import com.jahra.repository.TagRepository;
import com.jahra.service.ArticleService;
import com.jahra.service.TagService;
import com.jahra.utils.ArticleTitleIsInvalidException;
import com.jahra.utils.ArticleUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author a.vorushenko
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository repository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagService tagService;

    @Override
    @Transactional
    public Article newArticle(Article newArticle) throws ArticleTitleIsInvalidException {
        Article lastArticle = repository.findByUrl(ArticleUtils.createArticleUrl(newArticle));
        if (null != lastArticle
                && lastArticle.getCreationDate().equals(newArticle.getCreationDate())) {
            throw new ArticleTitleIsInvalidException();
        }
        List<Tag> tags = tagService.saveTags(newArticle.getTags().stream()
                .map(tag -> tag.getName()).collect(Collectors.toList()));
        newArticle.setTags(tags);
        newArticle.setCreationDate(new Date());
        newArticle.setUrl(ArticleUtils.createArticleUrl(newArticle));
        return repository.save(newArticle);
    }

    @Override
    @Transactional
    public Article findOne(Long id) {
        Article article = repository.findOne(id);
        Hibernate.initialize(article.getTags());
        return article;
    }

    @Override
    @Transactional
    public Article findByUrl(String url) {
        Article article = repository.findByUrl(url);
        Hibernate.initialize(article.getTags());
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        repository.delete(id);
    }



}
