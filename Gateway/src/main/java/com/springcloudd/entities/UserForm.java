package com.springcloudd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class UserForm {
    private String username;
    private String password;
    private String confirmedPassword;
    private String role;
    private Date date;
    private String email;
}
