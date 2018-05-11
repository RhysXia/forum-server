FROM java:8-jre-alpine
MAINTAINER Rhys <xrs4433@outlook.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/app/app.jar"]

ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar