package com.springboot.mywebapp.publisher;

import com.springboot.mywebapp.modal.ProductRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Channel;

@RestController
public class RedisPublisher {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic topic;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody ProductRedis productRedis) {
        redisTemplate.convertAndSend(topic.getTopic(), productRedis.toString());
        return ResponseEntity.status(HttpStatus.OK).body("Event Published.");
    }
}
