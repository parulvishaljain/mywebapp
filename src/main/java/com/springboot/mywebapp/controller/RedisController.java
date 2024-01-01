package com.springboot.mywebapp.controller;

import com.springboot.mywebapp.modal.ProductRedis;
import com.springboot.mywebapp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
public class RedisController {

    @Autowired
   private RedisService redisService;

    @PostMapping("/saveProductRedis")
    public ResponseEntity<?> save(@RequestBody ProductRedis productRedis) {
       ProductRedis productRedisObj =  redisService.save(productRedis);
       return ResponseEntity.status(HttpStatus.OK).body(productRedisObj);
    }

    @GetMapping("/findAllProductRedis")
    public ResponseEntity<?> findAll() {
        List<ProductRedis> productRedisList =  redisService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productRedisList);
    }

    @GetMapping("/findProductByIdRedis/{productRedisId}")
    public ResponseEntity<?> findProductById(@PathVariable int productRedisId) {
        ProductRedis productRedisObj =  redisService.findProductById(productRedisId);
        return ResponseEntity.status(HttpStatus.OK).body(productRedisObj);
    }
    @GetMapping("/deleteProductByIdRedis/{productRedisId}")
    public ResponseEntity<?> deleteProductById(@PathVariable int productRedisId) {
        String str =  redisService.deleteProduct(productRedisId);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }
}
