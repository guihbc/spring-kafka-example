package guihbc.kafka_example.application.ports;

import guihbc.kafka_example.domain.events.Event;

public interface KafkaEventPublisherPort {
    void publish(String topic, Event event);
}
