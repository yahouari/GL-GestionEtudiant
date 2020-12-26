package com.springcloudd;

import com.springcloudd.dao.EtudiantRepository;
import com.springcloudd.entities.Etudiant;
import com.springcloudd.entities.Role;
import com.springcloudd.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        Role etudiantRole=new Role(null,"ETUDIANT");
        accountService.saveRole(etudiantRole);
        Role profRole=new Role(null,"PROF");
        accountService.saveRole(profRole);
        

    }
}
