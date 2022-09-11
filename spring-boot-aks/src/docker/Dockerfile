FROM --platform=linux/amd64 azul/zulu-openjdk-alpine:17.0.2
COPY spring-boot-sample.jar spring-boot-sample.jar
USER root
EXPOSE 8080
CMD ["java", "-jar", "spring-boot-sample.jar"]
