
## Dependencias

* [Docker](https://docs.docker.com/get-docker/)
* [Docker Compose](https://docs.docker.com/compose/install/)

## Iniciar o Docker Compose

> docker-compose up -d

## Commands

> kafka-topics.sh --zookeeper 127.0.0.1:2181 --list  
> kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic first_topic  
> kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic first_topic  --from-beginning
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list  