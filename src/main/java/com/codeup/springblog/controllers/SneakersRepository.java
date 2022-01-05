package com.codeup.springblog.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SneakersRepository extends JpaRepository<Sneakers, Long>{
    Sneakers findByBrand(String brand);
    List<Sneakers> findAllByBrand (String brand);
}


