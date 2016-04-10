package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
    private Blog blog;


    @ManyToMany
    @JoinTable(name="article_has_tags", joinColumns={@JoinColumn(name="article_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")})
    private List<Tag> tags;


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (!id.equals(article.id)) return false;
        if (!title.equals(article.title)) return false;
        if (!content.equals(article.content)) return false;
        return url.equals(article.url);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
