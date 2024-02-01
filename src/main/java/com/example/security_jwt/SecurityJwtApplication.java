package com.example.security_jwt;

import com.example.security_jwt.auth.AuthenticationService;
import com.example.security_jwt.auth.RegisterRequest;
import com.example.security_jwt.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);

    }
    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service){
        return args->{
            var admin= RegisterRequest.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token : "+service.register(admin).getAccessToken());

            var manager= RegisterRequest.builder()
                    .firstName("Manager")
                    .lastName("Manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token : "+service.register(manager).getAccessToken());

        };

    }

}
