package com.codeup.springblog.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface SneakerRepository extends JpaRepository<Sneaker, Long>{
//    Sneaker findByBrand(String brand);
//    List<Sneaker> findAllByBrand (String brand);
}


