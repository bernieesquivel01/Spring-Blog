package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostControllers {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String posts(){
        return "post index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String viewPost(){
        return "view an individual post";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "view the form for creating a post";
    }

    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createPosts(){
        return "create a new post";
    }

}
