FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/recetas



COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/recetas/target/recetas-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

ENTRYPOINT ["java","-jar","recetas-0.0.1-SNAPSHOT.jar"]