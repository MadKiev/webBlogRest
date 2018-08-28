package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.BlogPost;
import com.gmail.madkiev.repository.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BlogPostController {
    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    @Autowired
    private BlogPostRepository blogPostRepository;

    @RequestMapping(value = "/blogPost", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost getTestBlogPost() {
        logger.info("Start getTestBlogPost");
        BlogPost blogPost = new BlogPost();
        blogPost.setId(UUID.randomUUID().toString());
        blogPost.setName("First blogPost");
        blogPost.setMessage("hello, it`s my first message in my blog.");
        return blogPost;
    }
    //get blog post by id
    @RequestMapping(value = "/blogPost/{id}", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost getBlogPost(@PathVariable("id") String blogPost) {
        logger.info("Start getBlogPost. ID="+blogPost);

        return blogPostRepository.getBlogPost(blogPost);
    }
    //get all blog post
    @RequestMapping(value = "/blogPosts", method = RequestMethod.GET)
    public @ResponseBody
    List<BlogPost> getAllBlogPost() {
        logger.info("Start getAllBlogPost.");
        return blogPostRepository.getBlogPost();
    }
    //create blog post
    @RequestMapping(value = "/blogPost", method = RequestMethod.POST)
    public @ResponseBody
    BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        logger.info("Start createRecipe.");
        return blogPostRepository.saveBlogPost(blogPost);
    }
    //delete blog post by id
    @RequestMapping(value = "/blogPost/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteBlogPost(@PathVariable("id") String blogPostId) {
        logger.info("Start deleteRecipe.");
        blogPostRepository.deleteBlogPost(blogPostId);
    }
}
