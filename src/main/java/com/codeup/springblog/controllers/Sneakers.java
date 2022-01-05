package com.codeup.springblog.controllers;

import javax.persistence.*;

@Entity
@Table(name="sneakers")
public class Sneakers {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 50)
        private String brand;

        @Column (nullable = false, length = 50)
        private String model;

        @Column (nullable = false, length = 100)
        private String name;

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String make) {
        this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }


