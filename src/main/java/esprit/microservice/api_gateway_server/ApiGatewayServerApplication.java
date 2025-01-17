package esprit.microservice.api_gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServerApplication.class, args);
    }
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("availability", r -> r.path("/v1/availability/**")
                        .uri("lb://medecin-service"))
                .route("medecins", r -> r.path("/v1/medecins/**")
                        .uri("lb://medecin-service"))
                .build();

    }
}
