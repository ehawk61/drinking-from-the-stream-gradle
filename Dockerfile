FROM gradle:jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
# RUN ["ls", "/home/gradle/src/scst-source/build/libs"]

FROM openjdk:11-jre-slim
COPY --from=builder /home/gradle/src/scst-source/build/libs/scst-source-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
CMD ["java","-jar","scst-source-0.0.1-SNAPSHOT.jar"]


