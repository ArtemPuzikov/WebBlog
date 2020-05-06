package com.blog.MyBlog.repositories;

import com.blog.MyBlog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
