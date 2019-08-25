package com.wizer.springboot.wizerchallenge.models;

public enum RoleType {
    LOANOFFICER("LoanManager"),
    BRANCHMANAGER("BranchManager"),
    ADMIN("Admin");

    private String name;

    RoleType(String name){
        this.name = name;
    }
}