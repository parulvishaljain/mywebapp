package com.springboot.mywebapp.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;


/*
* create 2 service
* account service
* payment service
* once payment is done
* do update on account service
* realtime usecase of publish and subscribe
* */
public class Receiver implements MessageListener {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("Consumed event {}", message);
    }
}
