package com.technicalevaluation.techeval.service;

import com.technicalevaluation.techeval.entity.Users;
import com.technicalevaluation.techeval.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author adan_ga
 */
@Service
public class JpaUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository repository;
     
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = repository.findByUsername(username);
        if(!optionalUser.isPresent()){            
            throw new UsernameNotFoundException(String.format("Username not found"));
        }
        
        Users user = optionalUser.orElseThrow();        
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        
        return new User(username, user.getPassword(), true, true,true, true, authorities);
    }
}
