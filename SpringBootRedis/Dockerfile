FROM maven:3.8.6-jdk-11 as maven
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/SpringBootRedis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]