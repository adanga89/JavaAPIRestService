/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.technicalevaluation.techeval.controllers;

import com.technicalevaluation.techeval.entity.PokemonInfo;
import com.technicalevaluation.techeval.entity.PokemonList;
import com.technicalevaluation.techeval.service.PokemonService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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
@RequestMapping("/api/pokemon")
public class pokemonController {
    
    @Autowired
    PokemonService Service;
    
    @GetMapping()
    public ResponseEntity<?> list() {
        PokemonList pkList = Service.ListOfPokemon(); 
        if(pkList == null)
            return ResponseEntity.badRequest().body("Error getting list");
        
        return ResponseEntity.ok(pkList);
    }
    
    @GetMapping("/{offset}/{limit}")
    public ResponseEntity<?> list(@PathVariable String offset, @PathVariable String limit){
        PokemonList pkList = Service.ListOfPokemon(offset, limit); 
        if(pkList == null)
            return ResponseEntity.badRequest().body("Error getting list");
        
        return ResponseEntity.ok(pkList);
    }
    
    
    @GetMapping("/{idOrName}")
    public ResponseEntity<?> get(@PathVariable String idOrName) {
        PokemonInfo pkInfo = Service.PokemonInfoById(idOrName);
        if(pkInfo == null)
            return ResponseEntity.badRequest().body("Pokemon not found");
        
        return ResponseEntity.ok(pkInfo);           
    }
    
}
