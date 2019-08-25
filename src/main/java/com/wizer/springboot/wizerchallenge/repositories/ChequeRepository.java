package com.wizer.springboot.wizerchallenge.repositories;

import com.wizer.springboot.wizerchallenge.models.Cheque;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChequeRepository extends MongoRepository<Cheque, Long>{}
