package com.springboot.mywebapp.controller;

import com.springboot.mywebapp.modal.Product;
import com.springboot.mywebapp.repository.ProductRepository;
import com.springboot.mywebapp.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public ResponseEntity<?> getAllProduct() {

        List<Product> allProducts = productService.findAllProduct();
        //JSONObject obj = new JSONObject();
       // obj.put("size", allProducts.size());
        //obj.put("products", allProducts);
        //Map<String,Object> map = new HashMap<>();

        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @GetMapping("/product/sort/{field}")
  private ResponseEntity<?> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductsWithSorting(field);
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ResponseEntity<?> getProductsPageWise(@PathVariable int offset, @PathVariable int pageSize) {
       Page<Product> products =  productService.findProductsWithPagination(offset,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/pagination/{offset}/{pageSize}/{field}")
    private ResponseEntity<?> getProductsPageWiseWithSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Product> products =  productService.findProductsWithPaginationWithSort(offset,pageSize,field);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
