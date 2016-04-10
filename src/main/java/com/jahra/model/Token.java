package com.jahra.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author a.vorushenko
 */
@Entity
@Table(name = "token")
public class Token implements Serializable {

    @Id
    @SequenceGenerator(name = "token_id_generator", sequenceName = "token_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_id_generator")
    private Long id;
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
