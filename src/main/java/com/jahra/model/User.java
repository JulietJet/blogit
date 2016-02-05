package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Артём on 29.07.15.
 */
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 24)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean isUserEnabled;

    @Column(name = "email", nullable = false, unique = true, length = 124)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private Set<UserRole> userRoles;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.REMOVE}, mappedBy = "owner")
    private Set<Blog> blogs;


    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserEnabled() {
        return isUserEnabled;
    }

    public void setUserEnabled(boolean userEnabled) {
        isUserEnabled = userEnabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
