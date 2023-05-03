package mx.com.autofin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition
@SpringBootApplication
@EnableFeignClients
public class RolesKeycloakApplication {

    public static void main(String[] args) {
        SpringApplication.run(RolesKeycloakApplication.class, args);
    }

}
