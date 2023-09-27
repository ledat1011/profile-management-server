FROM openjdk:11-jre-slim
EXPOSE 8801
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} comm-client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/comm-client-0.0.1-SNAPSHOT.jar"]