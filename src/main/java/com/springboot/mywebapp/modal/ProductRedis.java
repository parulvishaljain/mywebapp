package com.springboot.mywebapp.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("ProductRedis")
public class ProductRedis implements Serializable {

    @Id
    private int id;
    private String name;
    private int quantity;
    private long price;

    public ProductRedis(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
