package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

public class BlogPostRepositoryImpl implements BlogPostRepository {
    Map<String, BlogPost> BlogPostMap = new HashMap<>();

    @Override
    public List<BlogPost> getBlogPost() {
        return new ArrayList<>(BlogPostMap.values());
    }

    @Override
    public BlogPost getBlogPost(String id) {
        return BlogPostMap.get(id);
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        BlogPostMap.put(blogPost.getId(), blogPost);
        return BlogPostMap.get(blogPost.getId());
    }

    @Override
    public void deleteBlogPost(String id) {
        BlogPostMap.remove(id);
    }

}
