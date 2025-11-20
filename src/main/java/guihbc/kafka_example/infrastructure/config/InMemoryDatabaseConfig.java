package guihbc.kafka_example.infrastructure.config;

import guihbc.kafka_example.domain.events.OrderEvent;
import guihbc.kafka_example.domain.order.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class InMemoryDatabaseConfig {
    @Bean("ordersDatabase")
    Map<String, Order> ordersDataBase() {
        return new ConcurrentHashMap<>();
    }

    @Bean("orderEventDatabase")
    Map<String, OrderEvent> orderEventDatabase() {
        return new ConcurrentHashMap<>();
    }
}
