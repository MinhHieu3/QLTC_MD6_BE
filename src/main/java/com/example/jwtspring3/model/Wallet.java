package com.example.jwtspring3.model;

import jakarta.persistence.*;



@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String avatar;
    private Double money;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    private User user;

    public Wallet() {
    }

    public Wallet(Long id, String name, String avatar, Double money, String description, User user) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.money = money;
        this.description = description;
        this.user = user;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
