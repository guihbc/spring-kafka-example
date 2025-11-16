package guihbc.kafka_example.application.ports;

import guihbc.kafka_example.domain.events.Event;

public interface KafkaEventPublisher {
    void publish(String topic, Event event);
}
