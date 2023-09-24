FROM openjdk:11-jre-slim
EXPOSE 8082
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} profile-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/profile-service-0.0.1-SNAPSHOT.jar"]