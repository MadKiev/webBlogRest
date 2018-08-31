package com.gmail.madkiev.service;

import com.gmail.madkiev.model.BlogPost;
import com.gmail.madkiev.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public BlogPost getBlogPost(String id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Post with ID = '" + id  + "' not exist"));
    }

    @Override
    public List<BlogPost> getAllBlogPost() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteBlogPost(String id) {
        if (!blogPostRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("Post with ID = '" + id  + "' not exist");
        }
        blogPostRepository.deleteById(id);
    }
}
