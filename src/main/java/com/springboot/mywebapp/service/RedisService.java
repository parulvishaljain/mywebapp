package com.springboot.mywebapp.service;

import com.springboot.mywebapp.modal.ProductRedis;
import com.springboot.mywebapp.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    @Autowired
    private RedisRepository redisRepository;

    public ProductRedis save(ProductRedis productRedis) {
        redisRepository.save(productRedis);
        return productRedis;

    }

    public List<ProductRedis> findAll() {
       return redisRepository.findAll();
    }


    @Cacheable(key="#productId", value = "product_random_key", unless = "#result.price > 1000")
    public ProductRedis findProductById(int productId) {
        return redisRepository.findProductById(productId);
    }

    @CacheEvict(key = "#productId", value="product_random_key")
    // cache evict will remote the record from db as well as cache
    // cacheput will update the record in db as well as in cache
    public String deleteProduct(int productId) {
        return redisRepository.deleteProduct(productId);
    }
}
