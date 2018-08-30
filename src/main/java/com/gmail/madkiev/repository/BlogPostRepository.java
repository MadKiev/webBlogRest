package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, String> {
}
