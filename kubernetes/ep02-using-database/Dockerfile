FROM amazoncorretto:21-alpine-jdk

RUN apk update && apk add --no-cache tzdata
RUN addgroup -S spring && adduser -S spring -G spring

ENV TZ=Asia/Yangon

USER spring:spring

COPY target/*.jar app.jar

EXPOSE 8080/tcp

ENTRYPOINT ["java","-jar", "/app.jar"]