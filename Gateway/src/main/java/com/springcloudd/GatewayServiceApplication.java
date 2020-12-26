package com.springcloudd;


import com.springcloudd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class GatewayServiceApplication implements CommandLineRunner {
    @Autowired
    private AccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }


    RouteLocator staticRoute(RouteLocatorBuilder builder)
        {
            return builder.routes()
                    .route(r->r.path("/courses/**").uri("lb://COURS-SERVICE"))
                    .route(r->r.path("/inscriptions/**").uri("lb://INSCRIPTION-SERVICE"))
                    .route(r->r.path("/users/**").uri("lb://USER-SERVICE"))
                    .build();
        }
        @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp)
        {

            return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
        }
        @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder()
        {
            return new BCryptPasswordEncoder();
        }
    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
