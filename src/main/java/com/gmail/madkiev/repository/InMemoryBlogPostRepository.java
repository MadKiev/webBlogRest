package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.BlogPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBlogPostRepository implements BlogPostRepository {
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
