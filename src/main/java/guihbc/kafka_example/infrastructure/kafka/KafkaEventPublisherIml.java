package guihbc.kafka_example.infrastructure.kafka;

import guihbc.kafka_example.application.ports.KafkaEventPublisher;
import guihbc.kafka_example.domain.events.Event;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventPublisherIml implements KafkaEventPublisher {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public KafkaEventPublisherIml(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String topic, Event event) {
        kafkaTemplate.send(topic, event);
    }
}
