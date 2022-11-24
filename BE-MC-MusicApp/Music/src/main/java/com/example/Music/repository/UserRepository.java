package com.example.Music.repository;

import com.example.Music.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> {
    User findVyUserAId(String userid);
}
