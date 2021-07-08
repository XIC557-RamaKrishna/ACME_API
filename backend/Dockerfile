FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/demo-app-1.0.0.jar
ARG JAR_FILE=./build/libs/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
