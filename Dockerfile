FROM openjdk:17-jdk-alpine
MAINTAINER Mukul
COPY out/artifacts/Product_jar/Product.jar Product.jar
ENTRYPOINT ["java", "-jar", "/Product.jar"]