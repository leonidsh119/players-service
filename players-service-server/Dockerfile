FROM --platform=linux/amd64 openjdk:17-oracle
ARG JAR_FILE
VOLUME /tmp
ADD target/mend-graph-service-server-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 80