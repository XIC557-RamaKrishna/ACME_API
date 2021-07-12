FROM openjdk:8-jdk-alpine
ARG JAR_FILE=./build/libs/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
