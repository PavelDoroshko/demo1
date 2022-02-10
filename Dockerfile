FROM openjdk:11.0.9-jre-slim
MAINTAINER doroshko:demo1
COPY target/demo1-0.0.1-SNAPSHOT.jar demo1-0.0.1-SNAPSHOT.jar
CMD exec java -jar /demo1-0.0.1-SNAPSHOT.jar