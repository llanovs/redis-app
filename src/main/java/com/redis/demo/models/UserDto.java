package com.redis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Id
    private String id;

    private String name;
    private String email;
    private int age;
    private Gender gender;
}
