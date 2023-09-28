FROM openjdk:11-jre-slim
EXPOSE 8804
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} schedule-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/schedule-service-0.0.1-SNAPSHOT.jar"]