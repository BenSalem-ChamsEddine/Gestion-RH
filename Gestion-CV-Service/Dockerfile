FROM openjdk:8-jdk-alpine

ENV JAVA_OPTS="-Djava.awt.headless=true"

ADD target/Gestion-CV-Service-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8081

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
