FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -Pprd -Dmaven.test.skip

FROM openjdk:17-alpine

COPY --from=build /app/target/app.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8082
