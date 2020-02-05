package com.product.demo.productdemo.repository;

import com.product.demo.productdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
