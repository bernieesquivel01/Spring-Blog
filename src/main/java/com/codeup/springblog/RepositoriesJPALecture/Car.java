package com.codeup.springblog.RepositoriesJPALecture;

import javax.persistence.*; //brings in 'all' imports


@Entity
@Table(name="cars") //creates another table with specified name
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String make;

    @Column (nullable = false, length = 50)
    private String model;

    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
