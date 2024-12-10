FROM amazoncorretto:17

LABEL version="1.0"

EXPOSE 8190:8191
#ENV PORT 8190
#EXPOSE 8191

WORKDIR /app

COPY target/dockerspringbootmysql-0.0.1-SNAPSHOT.jar /app/dockerspringbootmysql.jar

ENTRYPOINT ["java", "-jar", "dockerspringbootmysql.jar"]