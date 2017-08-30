FROM openjdk:8-jdk-alpine

ENV JAVA_OPTS=""

ADD /target/Config-Service-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]