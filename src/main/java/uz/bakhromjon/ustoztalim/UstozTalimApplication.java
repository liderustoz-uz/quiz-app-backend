package uz.bakhromjon.ustoztalim;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = @Server(url = "https://6401545acac7.eu.ngrok.io/api"))
public class UstozTalimApplication {
    public static void main(String[] args) {
        SpringApplication.run(UstozTalimApplication.class, args);
    }
}
