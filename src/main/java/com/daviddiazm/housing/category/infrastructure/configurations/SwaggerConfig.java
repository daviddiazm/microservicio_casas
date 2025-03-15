package com.daviddiazm.housing.category.infrastructure.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservicio ubicaciones y categorías",
                description = "Es un microservicio con el que se administra las categorías que los inmuebles pueden ocupar y las ubicaciones que comprende desde el departamento hasta el municipio",
                contact = @Contact(
                        name = "David Diaz Montengro",
                        url = "https://daviddiazm.github.io/",
                        email = "davidcol123dm@gmail.com"
                )
        ),
        servers = {
                @Server(
                        description = "Server para desarrollo local",
                        url = "http://localhost:8081"
                )
        }
)
public class SwaggerConfig { }
