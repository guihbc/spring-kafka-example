package guihbc.kafka_example.application.ports;

import guihbc.kafka_example.domain.events.OrderEvent;
import guihbc.kafka_example.domain.order.Order;

import java.util.Optional;

public interface OrderRepositoryPort {
    String save(Order order);
    String saveEvent(OrderEvent orderEvent);
    Optional<Order> getById(String id);
}
