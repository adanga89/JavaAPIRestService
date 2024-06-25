/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.technicalevaluation.techeval.service;

import com.technicalevaluation.techeval.entity.Role;
import com.technicalevaluation.techeval.repository.UserRepository;
import com.technicalevaluation.techeval.entity.Users;
import com.technicalevaluation.techeval.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author adan_ga
 */
@Service
public class UsersService {
    
    @Autowired
    UserRepository  repository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    private Users sanitizeData(Users user){
        Users newUserClean = new Users();
        if(user.getId()>0){
            newUserClean.setId(user.getId());
            newUserClean.setUsername(HtmlUtils.htmlEscape(user.getUsername()));
            newUserClean.setPassword(passwordEncoder.encode(HtmlUtils.htmlEscape(user.getPassword())));
            newUserClean.setRoles((List<Role>) roleRepository.findByName(user.getUsername()));
            return newUserClean;
        }
        
        return null;
    }
    
    @Transactional
    public Users create(Users input){
        input = sanitizeData(input);
        if(input == null)
            return null;
        Users res  = repository.save(input);
        if(res.getId() != null)
            return res; 
        else
            return null;
    }
}
