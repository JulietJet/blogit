package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

    @Column(name = "creation_date", nullable = false, unique = false)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE}, mappedBy = "blog")
    private Set<Article> articles;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
