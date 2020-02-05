package com.product.demo.productdemo.repository;

import com.product.demo.productdemo.entity.Comment;
import com.product.demo.productdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
