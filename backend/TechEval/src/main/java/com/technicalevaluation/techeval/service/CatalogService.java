/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.technicalevaluation.techeval.service;

import com.technicalevaluation.techeval.entity.Catalog;
import com.technicalevaluation.techeval.repository.CatalogRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author adan_ga
 */
@Service
public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;  
    
    @Transactional(readOnly = true)
    public List<Catalog> catalogList(){
        return catalogRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Catalog> getCatalogById(String id) {
        return catalogRepository.findById(Long.valueOf(id));
    }
    
    private Catalog sanitizeData(Catalog catalog){
        Catalog newCatalogClean = new Catalog();
        if(catalog.getId()>0)
            newCatalogClean.setId(catalog.getId());
        newCatalogClean.setName(HtmlUtils.htmlEscape(catalog.getName()));
        newCatalogClean.setDescription(HtmlUtils.htmlEscape(catalog.getDescription()));
        
        return newCatalogClean;
    }
    
    public boolean isInvalid(Catalog input){
         return (input.getName().trim().isEmpty() || input.getDescription().trim().isEmpty());                
    }
    
    @Transactional
    public Catalog updateCatalog(String id, Catalog input){       
        Optional<Catalog> findById = catalogRepository.findById(Long.valueOf(id));
        
        if(!findById.isPresent())
            return null;
        
        input = sanitizeData(input);
        
        findById.get().setName(input.getName().trim());
        findById.get().setDescription(input.getDescription().trim());

        Catalog save = catalogRepository.save(findById.get());
        return save;
    }
 
    @Transactional
    public Catalog create(Catalog input){
        input = sanitizeData(input);
        Catalog res  = catalogRepository.save(input);
        if(res.getId() != null)
            return res; 
        else
            return null;
    }
    
    @Transactional
    public boolean delete(String id){
        if(!id.trim().isBlank()){
            Optional<Catalog> res = catalogRepository.findById(Long.valueOf(id));
            if(!res.isPresent())
                return false;
            catalogRepository.delete(res.get());
            res = catalogRepository.findById(Long.valueOf(id));
            return !res.isPresent();
        }
        return false;
    }
}
