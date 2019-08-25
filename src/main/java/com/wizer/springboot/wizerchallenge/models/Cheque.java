package com.wizer.springboot.wizerchallenge.models;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;

public class Cheque {
    
    private String bankName;

    private int startNumber;

    private int endNumber;

    
    private long id;

    public Cheque(long id, String bankName, int startNumber, int endNumber) {
        this.id = id;
        this.bankName = bankName;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public long getId(){
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