package com.lmw.entity;

import lombok.Data;

@Data
public class Account {

    private int id;
    private String username;
    private String password;
    private String role;
}
