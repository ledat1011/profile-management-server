FROM openjdk:11-jre-slim
EXPOSE 8761
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/server-0.0.1-SNAPSHOT.jar"]