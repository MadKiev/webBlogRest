package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.BlogPost;
import com.gmail.madkiev.repository.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping("/blogPost")
@Controller
public class BlogPostController {
    private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);

    @Autowired
    private BlogPostRepository blogPostRepository;

    @RequestMapping(value = "/blogPostTest", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost geGreetingBlogPost() {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(UUID.randomUUID().toString());
        blogPost.setName("First blogPost");
        blogPost.setMessage("hello, it`s my first message in my blog.");
        return blogPost;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    BlogPost getBlogPost(@PathVariable("id") String blogPost) {
        logger.info("Start getBlogPost. ID="+blogPost);

        return blogPostRepository.getBlogPost(blogPost);
    }
    @RequestMapping(value = "/allPosts", method = RequestMethod.GET)
    public @ResponseBody
    List<BlogPost> getAllBlogPost() {
        logger.info("Start getAllBlogPost.");
        return blogPostRepository.getBlogPost();
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        logger.info("Start createBlogPost.");
        return blogPostRepository.saveBlogPost(blogPost);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteBlogPost(@PathVariable("id") String blogPostId) {
        logger.info("Start deleteBlogPost.");
        blogPostRepository.deleteBlogPost(blogPostId);
    }
}
