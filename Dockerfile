FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/happy-family.jar happy-family.jar
ENTRYPOINT ["java","-jar","/happy-family.jar"]