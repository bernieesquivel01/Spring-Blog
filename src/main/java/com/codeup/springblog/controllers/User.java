package com.codeup.springblog.controllers;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column //(nullable = false, length = 50, unique = true)
    private String username;

    @Column //(nullable = false, length = 100, unique = true)
    private String email;

    @Column //(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Sneaker> userSneakers;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Sneaker> getUserSneakers() {
        return userSneakers;
    }

    public void setUserSneakers(List<Sneaker> userSneakers) {
        this.userSneakers = userSneakers;
    }


//    public User() {
//
//    }
//
//    //Read
//    public User(long id, String email, String username, String password){
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }
//
//    //Create
//    public User(String email, String username, String password){
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }

}
