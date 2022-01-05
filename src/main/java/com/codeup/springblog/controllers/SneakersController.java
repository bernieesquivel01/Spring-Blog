package com.codeup.springblog.controllers;

import com.codeup.springblog.RepositoriesJPALecture.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SneakersController {

    private final SneakersRepository sneakersDao;

    public SneakersController(SneakersRepository sneakersDao){
        this.sneakersDao = sneakersDao;
    }

    @GetMapping("/sneakers")
    public String sneakersIndex(Model model){
        model.addAttribute("sneakers", sneakersDao.findAll());

//        model.addAttribute("nike", sneakersDao.findByBrand("Nike"));
        model.addAttribute("nike", sneakersDao.findAllByBrand("Nike"));
        model.addAttribute("adidas", sneakersDao.findAllByBrand("Adidas"));

        return "sneakers";
    }

    @GetMapping("/add")
    public String showAddForm(){
        return "add";
    }

    @PostMapping("/add")
    public String addSneakers(@RequestParam(name="sneakers") String sneakers, Model model){
        return "add";
    }
}
