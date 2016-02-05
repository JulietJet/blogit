package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Артём on 31.01.2016.
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @SequenceGenerator(name = "article_id_generator", sequenceName = "article_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_generator")
    @Column(name = "article_id")
    private Long id;

    @Column(name = "title", nullable = false, unique = false)
    private String title;

    @Column(name = "content", nullable = false, unique = false)
    private String content;

    @Column(name = "creation_date", nullable = false, unique = false)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
