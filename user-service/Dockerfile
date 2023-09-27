FROM openjdk:11-jre-slim
EXPOSE 8803
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/user-service-0.0.1-SNAPSHOT.jar"]