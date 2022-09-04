FROM maven:latest
WORKDIR /usr/src/myapp
COPY . /usr/src/myapp
RUN mvn clean install
CMD ["java", "-jar", "target/plantei-backend-0.0.1-SNAPSHOT.jar"]
