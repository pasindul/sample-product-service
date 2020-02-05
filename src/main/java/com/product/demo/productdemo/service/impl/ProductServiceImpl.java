package com.product.demo.productdemo.service.impl;

import com.product.demo.productdemo.dto.response.ProductCreateResponse;
import com.product.demo.productdemo.entity.Comment;
import com.product.demo.productdemo.entity.Product;
import com.product.demo.productdemo.repository.ProductRepository;
import com.product.demo.productdemo.service.ProdutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProductServiceImpl implements ProdutService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public ProductCreateResponse createProduct(int count) {


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList> entity = restTemplate.getForEntity("http://names.drycodes.com/"+count, ArrayList.class);
        Set<Comment> comments = new HashSet<>();
        ProductCreateResponse productCreateResponse =  new ProductCreateResponse();
        int productCount=0;

        entity.getBody().forEach(name ->{

            Product product =  new Product();
            product.setName(name.toString());
            product.setContent(name.toString()+"_content");
            product.setDescription(name.toString()+"_description");

            ResponseEntity<ArrayList> commentList = restTemplate.getForEntity("http://names.drycodes.com/2", ArrayList.class);

            commentList.getBody().forEach(comm ->{
                Comment comment =  new Comment();
                comment.setText(comm.toString());
                comment.setProduct(product);
                comments.add(comment);
            });

            product.setComments(comments);
            productRepository.save(product);


        });

        productCreateResponse.setProductCount(count);
        return productCreateResponse;
    }

    @Override
    public List<Product> getAllProducts() {

       return productRepository.findAll();

    }
}

