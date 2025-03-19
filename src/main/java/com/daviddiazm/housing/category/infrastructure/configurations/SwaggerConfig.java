package com.daviddiazm.housing.category.infrastructure.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservice locations and categories",
                description = "It is a microservice that manages the categories that properties can occupy and the locations that it includes, from the department to the municipality.",
                contact = @Contact(
                        name = "David Diaz Montengro",
                        url = "https://daviddiazm.github.io/",
                        email = "davidcol123dm@gmail.com"
                )
        ),
        servers = {
                @Server(
                        description = "Server for local development",
                        url = "http://localhost:8081"
                )
        }
)
public class SwaggerConfig { }
