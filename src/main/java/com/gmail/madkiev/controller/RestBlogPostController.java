package com.gmail.madkiev.controller;

import com.gmail.madkiev.exception.RestOperationException;
import com.gmail.madkiev.model.BlogPost;
import com.gmail.madkiev.service.BlogPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "Blog post Controller", description = "Blog post control interface", produces = "application/json")
@RequestMapping("/api/v1/blogPost")
@Controller
public class RestBlogPostController implements BlogPostController{
    private static final Logger logger = LoggerFactory.getLogger(RestBlogPostController.class);

    @Autowired
    private BlogPostService blogPostService;

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
    List<BlogPost> getAllBlogPost(@ApiParam(name = "onlyMyPosts", value = "Target VOSaaS URL")
                                  @RequestParam(value = "onlyMyPosts", required = true) final boolean onlyMyPosts) {
        logger.info("Start getAllBlogPost.");
        if(onlyMyPosts) {
            return blogPostService.getUserBlogPostList(getUsernameFromAuth());
        }
        return blogPostService.getAllBlogPost();
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public @ResponseBody
    BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        logger.info("Start createBlogPost.");
        blogPost.setId(UUID.randomUUID().toString());
        blogPost.setOwnerId(getUsernameFromAuth());
        return blogPostService.saveBlogPost(blogPost);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    BlogPost updateBlogPost(@ApiParam(name = "id", value = "Unique identifier of a client app",
            required = true) @PathVariable String id, @RequestBody BlogPost blogPost) {
        logger.info("Update blog.");
        BlogPost oldPost = blogPostService.getBlogPost(id);
        if(oldPost != null) {
            blogPost.setId(id);
            blogPost.setOwnerId(getUsernameFromAuth());
        } else {
            if(!Objects.equals(getUsernameFromAuth(), blogPost.getOwnerId())) {
                throw new RestOperationException("You are not authorized to edit this post", HttpStatus.FORBIDDEN);
            }
            blogPost.setId(id);

        }

        return blogPostService.saveBlogPost(blogPost);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteBlogPost(@PathVariable("id") String blogPostId) {
        logger.info("Start deleteBlogPost.");
        try {
            BlogPost oldPost = blogPostService.getBlogPost(blogPostId);
            if(!Objects.equals(getUsernameFromAuth(), oldPost.getOwnerId())) {
                throw new RestOperationException("You are not authorized to delete this post", HttpStatus.FORBIDDEN);
            }
            blogPostService.deleteBlogPost(blogPostId);
        } catch (IllegalArgumentException iae) {
            throw new RestOperationException(iae.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private String getUsernameFromAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null) {
            throw new RestOperationException("You are not authenticated", HttpStatus.BAD_REQUEST);
        }
        return auth.getName();
    }
}
