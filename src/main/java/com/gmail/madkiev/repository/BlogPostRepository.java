package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BlogPostRepository {
    List<BlogPost> getBlogPost();

    BlogPost getBlogPost(String id);

    BlogPost saveBlogPost(BlogPost blogPost);

    void deleteBlogPost(String id);
}
