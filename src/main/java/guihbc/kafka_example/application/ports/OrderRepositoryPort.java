package guihbc.kafka_example.application.ports;

import guihbc.kafka_example.domain.order.Order;

public interface OrderRepositoryPort {
    String save(Order order);
}
