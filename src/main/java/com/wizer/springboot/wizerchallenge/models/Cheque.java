package com.wizer.springboot.wizerchallenge.models;

import java.math.BigInteger;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.wizer.springboot.wizerchallenge.repositories.UsersRepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;



@Document

public class Cheque {
    
    @ManyToOne
    private Users user;

    private String bankName;

    private int startNumber;

    private int endNumber;

    @Id @GeneratedValue private BigInteger id;
    public Cheque() {
        
    }


    public Cheque(String bankName, int startNumber, int endNumber, Users user) {
        this.bankName = bankName;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.user = user;
    }

    public BigInteger getId(){
        return this.id;
    }

    public String getBankName(){
        return this.bankName;
    }

    public int getStartNumber(){
        return this.startNumber;
    }

    public int getEndNumber(){
        return this.endNumber;
    }

}