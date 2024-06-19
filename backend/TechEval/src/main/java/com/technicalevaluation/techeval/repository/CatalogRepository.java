/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.technicalevaluation.techeval.repository;

import com.technicalevaluation.techeval.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author adan_ga
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    
}
