package com.redis.demo.msgs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Subscriber implements MessageListener {

    private final Logger LOG = LoggerFactory.getLogger(Subscriber.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        LOG.info("Event {}", message);
    }
}
