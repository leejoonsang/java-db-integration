package com.dbexercise.domain;

public class User {

    private String id;
    private String name;
    private String password;

    public User(){
    }

    public String getName() {
        return name;
    }

    public User(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
