FROM eclipse-temurin:17
COPY target/*.jar target/wordsl-core.jar
ENTRYPOINT java -jar target/wordsl-core.jar
