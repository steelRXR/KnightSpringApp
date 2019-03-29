package com.clockworkjava.kursspring.domain;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String role;

    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public Role() {
    }
}
