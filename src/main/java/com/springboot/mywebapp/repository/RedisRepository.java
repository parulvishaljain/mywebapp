package com.springboot.mywebapp.repository;


import com.springboot.mywebapp.modal.ProductRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisRepository {


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    public static final String PRODUCT_RAMDOM_KEY ="product_random_key";

    public ProductRedis save(ProductRedis productRedis) {
        redisTemplate.opsForHash().put(PRODUCT_RAMDOM_KEY,productRedis.getId(), productRedis);
        return productRedis;
    }

    public List<ProductRedis> findAll() {
       return redisTemplate.opsForHash().values(PRODUCT_RAMDOM_KEY);
    }

    public ProductRedis findProductById(int productRedisId) {
        System.out.println("call to redis storage");
       return (ProductRedis) redisTemplate.opsForHash().get(PRODUCT_RAMDOM_KEY, productRedisId);
    }

    public String deleteProduct(int productRedisId) {
        redisTemplate.opsForHash().delete(PRODUCT_RAMDOM_KEY, productRedisId);
        return "Product Deleted";
    }
}
