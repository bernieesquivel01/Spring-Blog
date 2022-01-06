package com.codeup.springblog.controllers;

import com.codeup.springblog.RepositoriesJPALecture.CarRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class SneakersController {

    private final SneakersRepository sneakersDao;

    public SneakersController(SneakersRepository sneakersDao) {
        this.sneakersDao = sneakersDao;
    }

//    @GetMapping("/sneakers")
//    public String sneakersIndex(Model model){
//        model.addAttribute("sneakers", sneakersDao.findAll());
//
////        model.addAttribute("nike", sneakersDao.findByBrand("Nike"));
//        model.addAttribute("nike", sneakersDao.findAllByBrand("Nike"));
//        model.addAttribute("adidas", sneakersDao.findAllByBrand("Adidas"));
//
//        return "sneakers";
//    }

    @GetMapping(path = "/sneakers")
    public String indexSneakers(Model model) {

        model.addAttribute("allSneakers", sneakersDao.findAll());

        return "sneakers/index";
    }

    @GetMapping(path = "/sneakers/{id}")
    public String individualSneaker(@PathVariable int id) {

        return "sneakers/show";
    }

    @PostMapping(path = "/sneakers/delete/{id}")
    public String deleteSneaker(@PathVariable long id) {
        long deleteSneakerId = id;
        sneakersDao.deleteById(deleteSneakerId);
        return "redirect:/sneakers";
    }

}