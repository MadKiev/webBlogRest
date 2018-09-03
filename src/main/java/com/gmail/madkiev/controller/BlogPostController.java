package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.BlogPost;

import java.util.List;

public interface BlogPostController {

    BlogPost getBlogPost(String blogPostId);
    List<BlogPost> getAllBlogPost(boolean onlyMyPosts);
    BlogPost createBlogPost(BlogPost blogPost);
    BlogPost updateBlogPost(String id, BlogPost blogPost);
    void deleteBlogPost(String blogPostId);
}
