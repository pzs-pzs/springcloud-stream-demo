package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    String username;
    String password;

}
