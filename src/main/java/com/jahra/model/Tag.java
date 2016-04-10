package com.jahra.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author a.vorushenko
 */
@Entity
@Table(name = "article_tag")
public class Tag {

    @Id
    @SequenceGenerator(name = "tag_id_generator", sequenceName = "tag_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_generator")
    @Column(name = "tag_id")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Article> articles;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return name;
    }
}
