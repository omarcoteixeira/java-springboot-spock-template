FROM amazoncorretto:17.0.3-alpine
RUN mkdir /app
COPY ./target/java-springboot-spock-template-spring-boot.jar /app/application.jar
WORKDIR /app

CMD "java" "-jar" "application.jar"