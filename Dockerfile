FROM openjdk:17
COPY /target/api-0.0.3-SNAPSHOT.jar api.jar
ADD opentelemetry-javaagent.jar /opentelemetry-javaagent.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-javaagent:/opentelemetry-javaagent.jar","api.jar"]