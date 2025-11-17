package guihbc.kafka_example.infrastructure.repository;

import guihbc.kafka_example.application.ports.OrderRepositoryPort;
import guihbc.kafka_example.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderRepository implements OrderRepositoryPort {
    @Override
    public String save(Order order) {
        return UUID.randomUUID().toString();
    }
}
