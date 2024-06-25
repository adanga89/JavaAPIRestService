/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.technicalevaluation.techeval.security;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

/**
 *
 * @author adan_ga
 */
public class TokenJwtConfig {
    
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATON = "Authorization";
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String CONTENT_TYPE = "application/json";
}
