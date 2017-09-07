FROM openjdk:8-jdk-alpine

ENV JAVA_OPTS=""

ADD /target/Config-Service-0.0.1-SNAPSHOT.jar Config-Service.jar

RUN sh -c 'touch /Config-Service.jar'

EXPOSE 8888

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /Config-Service.jar" ]