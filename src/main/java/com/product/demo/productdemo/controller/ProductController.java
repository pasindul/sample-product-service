package com.product.demo.productdemo.controller;

import com.product.demo.productdemo.dto.request.ProductCreateRequest;
import com.product.demo.productdemo.dto.response.ProductCreateResponse;
import com.product.demo.productdemo.dto.response.ProductViewResponse;
import com.product.demo.productdemo.entity.Product;
import com.product.demo.productdemo.service.ProdutService;
import com.product.demo.productdemo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProdutService produtService;

    @Autowired
    ObjectMapperUtils objectMapperUtils;


    @GetMapping("${app.endpoint.index}")
    public String index() {
        return "Hello";
    }


    @PostMapping("${app.endpoint.product}")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody ProductCreateRequest request) {

        ProductCreateResponse productCategoryResponse = produtService.createProduct(request.getCount());
        return new ResponseEntity<>(productCategoryResponse, HttpStatus.OK);

    }

    @GetMapping("${app.endpoint.product}")
    public ResponseEntity<List<ProductViewResponse>> getAllProducts() {
        List<Product> productList = produtService.getAllProducts();
        List<ProductViewResponse> productViewResponses = objectMapperUtils.mapAll(productList, ProductViewResponse.class);
        return new ResponseEntity<>(productViewResponses, HttpStatus.OK);

    }


}
