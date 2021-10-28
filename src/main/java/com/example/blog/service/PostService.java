package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Optional<Post> findForId(Long id);
    Post save(Post save);
    Page<Post> findAllOrderedByDatePageable(int page);
    void delete(Post post);
}
