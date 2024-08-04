FROM openjdk:21-slim

ENV LANG C.UTF-8

ADD 'target/car-server-0.0.1-SNAPSHOT.jar' car-server.jar

ENTRYPOINT ["java", "-jar", "car-server.jar"]

EXPOSE 8214