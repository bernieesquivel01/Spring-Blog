package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    public String indexPosts(Model viewModel){
        Post newPost1 = new Post ("Post 1", "Hi!");
        Post newPost2 = new Post ("Post 2", "Howdy");

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(newPost1);
        posts.add(newPost2);

        viewModel.addAttribute("post", posts);

        return "posts/index";
    }

    @GetMapping(path = "/posts/show")
    public String individualPost(Model viewModel){
        Post newPost = new Post ("Hello World", "Welcome to Codeup");
        viewModel.addAttribute("post", newPost);
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String viewCreatePost(){
        return "Placeholder for the create post form!";
    }

    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createPosts(){
        return "";
    }

}
