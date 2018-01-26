FROM java:8-jre
COPY build/masterApp-1.0.jar /work/
COPY build/slave-1.0.jar /work/
WORKDIR /work

ENTRYPOINT ["java", "-jar", "masterApp-1.0.jar"]

