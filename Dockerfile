# Usar imagem base leve com Java 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o .jar gerado pelo Maven para o container
COPY target/*.jar app.jar

# Expor a porta usada pela aplicação Spring Boot
EXPOSE 8081

# Comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
