package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostControllers {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String postsIndex(){
        return "post index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id){
        return "view an individual post" + id;
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
