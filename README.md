# Kafka Chat

Kafka-based chat application with GUI using Java, Docker and message streaming.

## Features

* Real-time chat using Apache Kafka
* Multiple clients (GUI)
* Message streaming via topics
* Docker-based Kafka setup
* Simple Swing GUI

## Technologies

* Java
* Apache Kafka
* Docker
* Swing

## How to run

1. Start Kafka (Docker):

docker-compose up -d

2. Build project:

mvn clean package

3. Run:

java -jar target/kafka-chat-1.0-SNAPSHOT-jar-with-dependencies.jar
