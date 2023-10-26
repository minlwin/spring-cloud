FROM amazoncorretto:17-alpine-jdk

RUN apk update && apk add --no-cache tzdata

RUN addgroup -S spring && adduser -S spring -G spring 

USER spring:spring

COPY target/*.jar app.jar
EXPOSE 8761/tcp

ENTRYPOINT ["java","-jar", "/app.jar"]