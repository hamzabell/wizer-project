package com.wizer.springboot.wizerchallenge.models;

import java.util.ArrayList;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sun.tools.javac.util.List;

public class Users {


    private final long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "The Branch of this User is required")
    private String branch;

    @NotNull(message = "User Role is required")
    private RoleType role;

    @OneToMany
    private Cheque cheque;

     
    public Users(long id, String username, String password, String branch, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.branch = branch;
        this.id = id;
    }

    public long getId(){
        return id;
    }
    public String getBranch(){
        return branch;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public RoleType getRole(){
        return role;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void addCheque(Cheque cheque){
        this.cheque = cheque;
    }
}