/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.technicalevaluation.techeval.repository;

import com.technicalevaluation.techeval.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adan_ga
 */
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String name);
}
