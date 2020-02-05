package com.product.demo.productdemo.service;

import com.product.demo.productdemo.dto.response.ProductCreateResponse;
import com.product.demo.productdemo.entity.Product;

import java.util.List;

public interface ProdutService {

    ProductCreateResponse createProduct(int count);
    List<Product> getAllProducts();
}
