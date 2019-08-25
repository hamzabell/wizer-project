package com.wizer.springboot.wizerchallenge.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import com.wizer.springboot.wizerchallenge.models.Cheque;
import com.wizer.springboot.wizerchallenge.repositories.ChequeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class ChequeController {

    @Autowired
    private ChequeRepository chequeRepository;



    @RequestMapping(value= "/list-cheques",method = RequestMethod.GET)
    public ResponseEntity<Object> getCheques(){
        return new ResponseEntity<>(chequeRepository.findAll(), HttpStatus.OK);
    }
   
}