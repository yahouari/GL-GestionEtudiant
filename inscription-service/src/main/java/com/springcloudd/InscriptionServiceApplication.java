package com.springcloudd;

import com.springcloudd.entities.Cours;
import com.springcloudd.entities.Inscription;
import com.springcloudd.services.CoursService;
import com.springcloudd.services.InscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class InscriptionServiceApplication implements CommandLineRunner {
    @Autowired
    private InscriptionServiceImpl inscriptionService;
    @Autowired
    private CoursService coursService;
    public static void main(String[] args) {
        SpringApplication.run(InscriptionServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {





    }
}
