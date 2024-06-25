package com.technicalevaluation.techeval.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author adan_ga
 */
public abstract class SimpleGrantedAuthorityJsonCreator {
    
    @JsonCreator
    public SimpleGrantedAuthorityJsonCreator(@JsonProperty("authority") String role){}
}
