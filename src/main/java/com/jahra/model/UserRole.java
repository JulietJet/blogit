package com.jahra.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Артём on 29.07.15.
 */
@Entity
@Table(name="user_role")
public class UserRole implements Serializable{
    @Id
    @SequenceGenerator(name = "user_role_id_generator", sequenceName = "user_role_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_generator")
    @Column(name = "role_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role", nullable = false)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
