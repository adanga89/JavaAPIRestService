/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.technicalevaluation.techeval.service;

import com.technicalevaluation.techeval.entity.PokemonInfo;
import com.technicalevaluation.techeval.entity.PokemonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author adan_ga
 */
@Service
public class PokemonService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${custom.externalApi}")
    private String apiUrl;
    
    public PokemonList ListOfPokemon(String Offset, String limit) { 
        try{
            return restTemplate.getForObject(apiUrl+"?offset=" + Math.abs(Integer.parseInt(Offset)) + "&limit=" + Math.abs(Integer.parseInt(limit)), PokemonList.class);
        }
        catch(RestClientException e){
            return  null;
        }
    }
    
    public PokemonList ListOfPokemon() {        
        try{    
            return restTemplate.getForObject(apiUrl, PokemonList.class);
        }
        catch(RestClientException e){
            return  null;
        }
    }
    
    public PokemonInfo PokemonInfoById(String id) {
        try{
            return restTemplate.getForObject(apiUrl+"/"+id, PokemonInfo.class);
        }
        catch(RestClientException e){
            return  null;
        }        
    }
    
}
