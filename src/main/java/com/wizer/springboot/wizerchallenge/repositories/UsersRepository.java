package com.wizer.springboot.wizerchallenge.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wizer.springboot.wizerchallenge.models.Users;


public interface UsersRepository extends MongoRepository<Users, Long>{
    Users findByUsername(String username);
}