package guihbc.kafka_example.infrastructure.kafka;

import guihbc.kafka_example.application.ports.KafkaEventPublisherPort;
import guihbc.kafka_example.domain.events.Event;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisher implements KafkaEventPublisherPort {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String topic, Event event) {
        kafkaTemplate.send(topic, event);
    }
}
