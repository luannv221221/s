package com.example.demo_gateway;

import com.example.demo_gateway.config.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGatewayApplication {
    @Autowired
    private AuthenticationFilter filter;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test1/**").filters(f->f.filter(filter))
                        .uri("http://localhost:8081/"))
                .route(r->r.path("/auth/**","/admin/**").uri("http://localhost:8080/"))
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayApplication.class, args);
    }

}
