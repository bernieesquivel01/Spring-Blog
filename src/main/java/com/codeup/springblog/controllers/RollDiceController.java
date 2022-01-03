package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDiceView() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userGuess}")
    public String rollDiceN(@PathVariable int userGuess, Model model) {
        String message;

        int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        if(userGuess == randomNumber) {
            message = "Good Guess!";
        } else {
            message = "Wrong! Try again!";
        }

        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("userGuess", userGuess);
        model.addAttribute("message", message);

        return "roll-results";
    }
}
