/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author kmlnd
 */
public class PWEnc {
    public static void main(String[] args) {
        String clearTxtPw = "password";
        //BCrypt
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPw = encoder.encode(clearTxtPw);
        System.out.println(hashedPw);
        
        String clear="password";
        String newPass = encoder.encode(clear);
        System.out.println(newPass);
    }
}
