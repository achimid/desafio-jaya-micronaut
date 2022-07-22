FROM adoptopenjdk/openjdk11:latest 

COPY build/libs/*all.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
