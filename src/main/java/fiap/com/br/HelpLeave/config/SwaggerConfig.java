package fiap.com.br.HelpLeave.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API HelpLeave – Sistema de Evacuação e Encontro de Abrigos")
                .version("1.0")
                .description("Esta API oferece recursos para gestão de usuários, localização de abrigo, emissão de alertas e segurança em situações de risco.\n\n"
                           + "🔐 Endpoints protegidos exigem autenticação JWT.")
                .contact(new Contact()
                    .name("Equipe HelpLeave"))
            )
            .servers(List.of(
                new Server().url("http://localhost:8082").description("Servidor Local"),
                new Server().url("https://helpleave.azurewebsites.net").description("Servidor em Produção")
            ))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .name("Authorization")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }
}
