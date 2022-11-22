# syntax=docker/dockerfile:1.4

FROM maven:3.8.6-jdk-11-slim AS builder
WORKDIR /plantei
COPY plantei-backend/pom.xml plantei-backend/plantei.xml .
COPY plantei-backend/.mvn/ .mvn
RUN ["mvn", "dependency:resolve"]
COPY plantei-backend/src/ src
RUN sed -i '2s/\/\/localhost\:5432/\/\/database\:5432/' src/main/resources/application.properties
RUN ["mvn", "-T", "4", "clean", "install", "-DskipTests"]

FROM gcr.io/distroless/java11-debian11
WORKDIR /plantei
COPY --from=builder /plantei/target/plantei-backend-0.0.1-SNAPSHOT.jar .
CMD ["plantei-backend-0.0.1-SNAPSHOT.jar"]
