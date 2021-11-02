package com.redis.demo.repositories;

import com.redis.demo.models.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDto, String> {
}
