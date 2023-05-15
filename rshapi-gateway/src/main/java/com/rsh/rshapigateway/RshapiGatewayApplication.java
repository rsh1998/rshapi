package com.rsh.rshapigateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDubbo
public class RshapiGatewayApplication {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("tobaidu", r -> r.path("/baidu")
                        .uri("https://www.baidu.com"))
                .route("toyupi", r -> r.path("/yupiicu")
                        .uri("http://yupi.icu"))
                .build();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RshapiGatewayApplication.class, args);
    }

}
