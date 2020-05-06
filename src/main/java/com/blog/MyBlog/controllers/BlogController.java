package com.blog.MyBlog.controllers;

import com.blog.MyBlog.models.Post;
import com.blog.MyBlog.repositories.PostRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework. beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title,@RequestParam String anons,@RequestParam String fullText, Model model) {
        Post post = new Post(title,anons,fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }
}
