FROM java:8-jre

# Add the service itself
ARG JAR_FILE
ADD ${JAR_FILE} /
ENTRYPOINT ["java", "-jar", "target/classLoadersTest-1.0.jar"]
