FROM clojure:alpine

RUN mkdir -p /app
RUN mkdir -p /opt/byteart

WORKDIR /app

COPY project.clj /app
# RUN lein deps

COPY . /app
# RUN lein uberjar

EXPOSE 3000
CMD ["java", "-jar", "target/byteart-svg-0.1.0-SNAPSHOT-standalone.jar"]
