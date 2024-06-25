/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.technicalevaluation.techeval.controllers;

import com.technicalevaluation.techeval.entity.Users;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author adan_ga
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
      
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Users input) {
        return null;
    }   
}
