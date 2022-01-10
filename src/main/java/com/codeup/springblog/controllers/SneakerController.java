package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SneakerController {

    private SneakerRepository sneakerDao;
    private UserRepository userDao;
    private EmailService emailService;

    public SneakerController(SneakerRepository sneakerDao, UserRepository userDao, EmailService emailService) {
        this.sneakerDao = sneakerDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

        model.addAttribute("allSneakers", sneakerDao.findAll());

        return "sneakers/index";
    }

    @GetMapping(path = "/sneakers/{id}")
    public String individualSneaker(@PathVariable int id) {

        return "sneakers/show";
    }

    @GetMapping("/sneakers/create")
    public String viewCreateSneaker(Model model){
//        Sneaker sneaker = new Sneaker();
//        sneaker.setName("New Balance For Dads");
//        sneaker.setBrand("New Balance");
//        sneaker.setModel("Sport Edition");
//
//
//        User user = new User();
//
//        user.setUsername("bernie");
//        user.setEmail("bernie2cool@yahoo.com");
//        user.setPassword("supersecretPW");

//        userDao.save(user);
//
//        sneaker.setUser(user);
//
//        sneakerDao.save(sneaker);
        model.addAttribute("sneaker", new Sneaker());
        return "sneakers/create";
    }

    @PostMapping("/sneakers/create")
    public String createSneaker(@ModelAttribute Sneaker sneaker){

        User sneakerCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sneaker.setUser(sneakerCreator);

        String emailSubject = sneaker.getUser().getUsername() + ", your post has been created.";
        String emailBody = "Congratulations - your latest sneaker has been added and ready to view on your site. Your post read: " + sneaker.getModel() +  sneaker.getName();

        emailService.prepareAndSend(sneaker, emailSubject,  emailBody);
        sneakerDao.save(sneaker);
//    public String createSneaker(@RequestParam(name="sneakerBrand") String sneakerBrand, @RequestParam(name="sneakerModel") String sneakerModel, @RequestParam(name="sneakerName") String sneakerName){
//
//        Sneaker newSneaker = new Sneaker();
//        newSneaker.setBrand(sneakerBrand);
//        newSneaker.setModel(sneakerModel);
//        newSneaker.setName(sneakerName);
//        newSneaker.setUser(userDao.getById(1L));
//
//        sneakerDao.save(newSneaker);
        return "redirect:/sneakers";
    }

    @GetMapping(path = "/sneakers/edit/{id}")
    public String editSneaker(@PathVariable long id, Model model){
        Sneaker editSneaker = sneakerDao.getById(id);

        model.addAttribute("sneakerToEdit", editSneaker);

        return "sneakers/edit";
    }

    @PostMapping("/sneakers/edit")
    public String saveEditSneaker(@RequestParam(name="sneakerBrand") String sneakerBrand, @RequestParam(name="sneakerModel") String sneakerModel, @RequestParam(name="sneakerName") String sneakerName, @RequestParam(name="sneakerId") long id){

        Sneaker sneakerToEdit = sneakerDao.getById(id);
        sneakerToEdit.setBrand(sneakerBrand);
        sneakerToEdit.setModel(sneakerModel);
        sneakerToEdit.setName(sneakerName);

        sneakerDao.save(sneakerToEdit);

        return "redirect:/sneakers";
    }

    @PostMapping(path = "/sneakers/delete/{id}")
    public String deleteSneaker(@PathVariable long id) {
        long deleteSneakerId = id;
        sneakerDao.deleteById(deleteSneakerId);
        return "redirect:/sneakers";
    }



}