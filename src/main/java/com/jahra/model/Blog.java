package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Артём on 31.01.2016.
 */
@Entity
@Table(name = "user_blog")
public class Blog implements Serializable {

    @Id
    @SequenceGenerator(name = "blog_id_generator", sequenceName = "blog_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_id_generator")
    @Column(name = "blog_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "last_update_date", nullable = false, unique = false)
    private Date lastUpdateDate;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User owner;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.REMOVE}, mappedBy = "blog")
    private List<Article> articles;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
