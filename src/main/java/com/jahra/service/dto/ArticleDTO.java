package com.jahra.service.dto;

import com.jahra.model.Article;

import java.util.Date;

/**
 * Created by Артём on 01.02.2016.
 */
public class ArticleDTO {

    private Long id;
    private String title;
    private String content;
    private String url;
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCreationDate(dto.getCreationDate());
        return article;
    }
}
