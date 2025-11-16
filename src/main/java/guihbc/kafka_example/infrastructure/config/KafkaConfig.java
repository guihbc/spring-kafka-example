package guihbc.kafka_example.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic orderEventTopic() {
        return TopicBuilder.name("orders.events.v1")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
