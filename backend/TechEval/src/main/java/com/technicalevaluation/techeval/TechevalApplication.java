package com.technicalevaluation.techeval;

import com.technicalevaluation.techeval.entity.Role;
import com.technicalevaluation.techeval.entity.Users;
import com.technicalevaluation.techeval.repository.RoleRepository;
import com.technicalevaluation.techeval.repository.UserRepository;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TechevalApplication {

	public static void main(String[] args) {
                ApplicationContext context = SpringApplication.run(TechevalApplication.class, args);
                TechevalApplication.createData(context);                
	}
        
        private static void createData(ApplicationContext context){
            RoleRepository repository = context.getBean(RoleRepository.class);                
            UserRepository userRepository = context.getBean(UserRepository.class);
            
            Role rol = new Role();
            rol.setId(Long.valueOf(1));
            rol.setName("ROLE_USER");                
            repository.save(rol);
            Users user = new Users();       
            user.setId(Long.valueOf(1));
            user.setUsername("user");                
            user.setPassword("$2a$12$6TBO7sYdIBUC2S7gyHMdQusWTD/Vog8NvYr6efgJXciy752GhSKDS");            
            user.setRoles(Arrays.asList(rol));
            userRepository.save(user);
            
            rol.setId(Long.valueOf(2));
            rol.setName("ROLE_ADMIN");                
            repository.save(rol);                        
            user.setId(Long.valueOf(2));
            user.setUsername("admin");                
            user.setPassword("$2a$12$6TBO7sYdIBUC2S7gyHMdQusWTD/Vog8NvYr6efgJXciy752GhSKDS");
            user.setRoles(Arrays.asList(rol));
            userRepository.save(user);
            
            userRepository = null;
            user = null;
            repository = null;
            rol = null;      
        }
        
}
