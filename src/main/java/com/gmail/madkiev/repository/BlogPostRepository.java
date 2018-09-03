package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, String> {
    List<BlogPost> findAllByOwnerId(String ownerId);
}
