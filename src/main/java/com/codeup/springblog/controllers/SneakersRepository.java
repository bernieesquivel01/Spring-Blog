package com.codeup.springblog.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SneakersRepository extends JpaRepository<Sneaker, Long>{
//    Sneaker findByBrand(String brand);
    List<Sneaker> findAllByBrand (String brand);
}


