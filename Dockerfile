FROM openjdk:jre-alpine
WORKDIR /opt/bank/
ADD target/bank.jar /opt/bank/
CMD ["java","-jar","/opt/bank/bank.jar"]
EXPOSE 8081/tcp
