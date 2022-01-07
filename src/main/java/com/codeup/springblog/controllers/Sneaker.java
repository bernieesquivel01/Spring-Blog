package com.codeup.springblog.controllers;

import javax.persistence.*;

@Entity
@Table(name = "sneakers")
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    public Sneaker() {
//
//    }

//    public Sneaker(String brand, String model, String name, User user) {
//        this.brand = brand;
//        this.model = model;
//        this.name = name;
//        this.user = user;
//    }
//
//    public Sneaker(long id, String brand, String model, String name, User user) {
//        this.id = id;
//        this.brand = brand;
//        this.model = model;
//        this.name = name;
//        this.user = user;
//    }

}


