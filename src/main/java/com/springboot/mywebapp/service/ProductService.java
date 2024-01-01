package com.springboot.mywebapp.service;

import com.springboot.mywebapp.modal.Product;
import com.springboot.mywebapp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

  /*  @PostConstruct
    public void initDB() {
     //   Product p = new Product();
        List<Product> products = IntStream.rangeClosed(1,200).
                mapToObj(i-> new Product("product" + i, new Random().nextInt(100),
                        new Random().nextInt(50000))).toList();

        repository.saveAll(products);
    }*/

    public List<Product> findAllProduct() {
        return repository.findAll();
    }

    public List<Product> findProductsWithSorting(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    //offset - it's your page number
    // pagesize - number of records per page
    public Page<Product> findProductsWithPagination(int offset, int pageSize) {
        Page<Product> products = repository.findAll(PageRequest.of(offset,pageSize));
        return products;
    }

    public Page<Product> findProductsWithPaginationWithSort(int offset, int pageSize, String field) {
        Page<Product> products = repository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return products;
    }

}
