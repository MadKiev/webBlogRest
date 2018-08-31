package com.gmail.madkiev.service;

import com.gmail.madkiev.model.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPost getBlogPost(String blogPost);
    List<BlogPost> getAllBlogPost();
    BlogPost saveBlogPost(BlogPost blogPost);
    void deleteBlogPost(String blogPostId);
}
