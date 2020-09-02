package dev.allanlarangeiras.kafkapoc;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.stream.IntStream;

public class ProducerPOC {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ProducerPOC.class.getName());
        String bootstrapServers = "127.0.0.1:9092";
        String topic = "first_topic";


        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i : IntStream.range(1, 10).toArray()) {
            ProducerRecord<String, String> record
                    = new ProducerRecord<String, String>(topic, String.format("Hello World %s", i));
            producer.send(record);
            producer.flush();
        }

        producer.close();

    }

}
