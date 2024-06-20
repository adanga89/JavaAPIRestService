/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.technicalevaluation.techeval.entity;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author adan_ga
 */
@Data
public class PokemonList {
    private float count;
    private String next;
    private String previous = null;
    ArrayList <Object> results = new ArrayList<>(); 
}
