/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.technicalevaluation.techeval.controllers;

import com.technicalevaluation.techeval.entity.Catalog;
import com.technicalevaluation.techeval.service.CatalogService;
import java.util.Collections;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author adan_ga
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {
    
    @Autowired
    CatalogService Service;
    
    @GetMapping()
    public List<Catalog> list() {
        return Service.catalogList();
    }
    
    @GetMapping("/{id}")
    public Catalog get(@PathVariable String id) {
        Optional<Catalog> res = Service.getCatalogById(id);
        if(res.isPresent())
            return res.get();
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Catalog input) {
        if(Service.isInvalid(input))
           return ResponseEntity.badRequest().body("Some required params are empty");
        
        Catalog updatedCatalog = Service.updateCatalog(id,input);
        if(updatedCatalog == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedCatalog);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Catalog input) {
         if(Service.isInvalid(input))
           return ResponseEntity.badRequest().body("Some required params are empty");
         
        Catalog res = Service.create(input);
        if(res != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "The record wasn't save."));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if(Service.delete(id)){            
            return ResponseEntity.ok("Deleted Item Correctly.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The ID not Exist.");
    }
    
}
