# GS_HelpLeave

# 🚨 HelpLeave – Sistema de Evacuação e Rotas Seguras

Este projeto é uma API REST desenvolvida em Java com Spring Boot para auxiliar na evacuação de pessoas em situações de risco, fornecendo rotas seguras em tempo real.

## 📌 Funcionalidades

- ✅ Cadastro e autenticação de usuários
- ✅ Cadastro e listagem de rotas de evacuação
- ✅ Proteção com autenticação JWT
- ✅ Documentação automática com Swagger

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- Banco de dados Oracle
- OpenAPI / Swagger
- Docker

---

## 🚀 Como Executar Localmente

1. Clone o projeto:
   ```bash
   git clone https://github.com/seuusuario/helpleave.git
   cd helpleave
Configure o application.properties com as credenciais do banco Oracle:

ini
Copiar
Editar
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl
spring.datasource.username=RMxxxxxx
spring.datasource.password=suasenha
Execute o projeto:

bash
Copiar
Editar
./mvnw spring-boot:run
Acesse:

Swagger: http://localhost:8080/swagger-ui/index.html

API: http://localhost:8080

📦 Deploy em Nuvem com Docker + Azure
1. Crie o Dockerfile
O projeto já inclui o Dockerfile pronto.

2. Execute o script de deploy
Dê permissão e execute o script:

bash
Copiar
Editar
chmod +x deploy-azure.sh
./deploy-azure.sh
Esse script:

Faz login no Azure

Cria grupo de recursos, registro de container e app service (se necessário)

Constrói e publica a imagem Docker no Azure Container Registry

Cria o App Service com base na imagem
