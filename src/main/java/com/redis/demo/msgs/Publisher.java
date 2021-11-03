package com.redis.demo.msgs;

import com.redis.demo.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Autowired
    private ChannelTopic topic;

    @PostMapping("/send")
    public String publish(@RequestBody UserDto user) {
        template.convertAndSend(topic.getTopic(), user.toString());
        return "Event published";
    }
}
