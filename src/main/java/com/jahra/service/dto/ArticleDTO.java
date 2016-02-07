package com.jahra.service.dto;

import com.jahra.model.Article;
import com.jahra.utils.ArticleUtils;

import java.text.ParseException;

/**
 * Created by Артём on 01.02.2016.
 */
public class ArticleDTO {

    private Long id;
    private String title;
    private String content;
    private String url;
    private String creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Article toEntity(ArticleDTO dto) {
        Article article = new Article();
        if (dto == null) {
            return article;
        }
        try {
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
            article.setCreationDate(ArticleUtils.getSimpleDateFormat().parse(dto.getCreationDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return article;
    }

    public static ArticleDTO fromEntity(Article article) {
        ArticleDTO dto = new ArticleDTO();
        if (article == null) {
            return dto;
        }
        dto.setId(article.getId());
        dto.setContent(article.getContent());
        dto.setTitle(article.getTitle());
        dto.setUrl(ArticleUtils.getUrl(article.getBlog().getName())
                + "/" + article.getId() + "/"
                + ArticleUtils.getUrl(article.getTitle()));
        dto.setCreationDate(ArticleUtils.getSimpleDateFormat().format(article.getCreationDate()));
        return dto;
    }


}
