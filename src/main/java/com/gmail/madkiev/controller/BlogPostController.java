package com.gmail.madkiev.controller;

import com.gmail.madkiev.exception.RestOperationException;
import com.gmail.madkiev.model.BlogPost;
import com.gmail.madkiev.repository.BlogPostRepository;
import com.gmail.madkiev.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping("/blogPost")
@Controller
public class BlogPostController {
    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping(value = "/blogPostTest", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost geGreetingBlogPost() {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(UUID.randomUUID().toString());
        blogPost.setName("First blogPost");
        blogPost.setMessage("hello, it`s my first message in my blog.");
        return blogPost;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost getBlogPost(@PathVariable("id") String blogPostId) {
        logger.info("Start getBlogPost. ID="+blogPostId);
        try {
            return blogPostService.getBlogPost(blogPostId);
        } catch (IllegalArgumentException iae) {
            throw new RestOperationException(iae.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public @ResponseBody
    List<BlogPost> getAllBlogPost() {
        logger.info("Start getAllBlogPost.");
        return blogPostService.getAllBlogPost();
    }
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public @ResponseBody
    BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        logger.info("Start createBlogPost.");
        return blogPostService.saveBlogPost(blogPost);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    BlogPost updateBlogPost(@RequestBody BlogPost blogPost) {
        logger.info("Update blog.");
        return blogPostService.saveBlogPost(blogPost);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteBlogPost(@PathVariable("id") String blogPostId) {
        logger.info("Start deleteBlogPost.");
        try {
            blogPostService.deleteBlogPost(blogPostId);
        } catch (IllegalArgumentException iae) {
            throw new RestOperationException(iae.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
