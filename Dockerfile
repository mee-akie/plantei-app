FROM maven:latest
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN mvn clean install
CMD ["java", "-jar", "target/plantei-backend-0.0.1-SNAPSHOT.jar"]
