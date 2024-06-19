/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.technicalevaluation.techeval.controllers;

import com.technicalevaluation.techeval.entity.Catalog;
import com.technicalevaluation.techeval.repository.CatalogRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    CatalogRepository CatalogR;
    
    @GetMapping()
    public List<Catalog> list() {
        return CatalogR.findAll();
    }
    
    @GetMapping("/{id}")
    public Catalog get(@PathVariable String id) {
        Optional<Catalog> res = CatalogR.findById(Long.valueOf(id));
        if(res.isPresent())
            return res.get();
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Catalog input) {
        if(input.getName().trim().isEmpty() || input.getDescription().trim().isEmpty())
           return ResponseEntity.badRequest().body("Some required params are empty");
        Optional<Catalog> findById = CatalogR.findById(Long.valueOf(id));
        if(!findById.isPresent())
            return ResponseEntity.notFound().build();
        
        findById.get().setName(input.getName().trim());
        findById.get().setDescription(input.getDescription().trim());

        Catalog save = CatalogR.save(findById.get());
        return ResponseEntity.ok(save);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Catalog input) {
        if(input.getName().trim().isEmpty() || input.getDescription().trim().isEmpty())
            return ResponseEntity.badRequest().body("Some required params are empty");
        Catalog res = CatalogR.save(input);
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if(!id.trim().isBlank()){
            Optional<Catalog> res = CatalogR.findById(Long.valueOf(id));
            if(!res.isPresent())
                return ResponseEntity.badRequest().body("The ID not Exist.");
            CatalogR.delete(res.get());
            return ResponseEntity.ok("Deleted Item Correctly.");
        }
        return ResponseEntity.badRequest().body("The ID not Exist.");
    }
    
}
