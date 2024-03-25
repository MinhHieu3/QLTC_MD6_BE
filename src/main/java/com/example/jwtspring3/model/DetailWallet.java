package com.example.jwtspring3.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DetailWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double money;
    private String description;

    private LocalDate time;

    @ManyToOne
    private Wallet wallet;
    @ManyToOne
    private Category category;

    public DetailWallet() {
        this.time = LocalDate.now();
    }


    public DetailWallet(Long id, Double money, String description, Wallet wallet, Category category) {
        this.id = id;
        this.money = money;
        this.description = description;
        this.time = LocalDate.now();
        this.wallet = wallet;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}