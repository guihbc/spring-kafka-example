package guihbc.kafka_example.infrastructure.repository;

import guihbc.kafka_example.application.ports.OrderRepositoryPort;
import guihbc.kafka_example.domain.events.OrderEvent;
import guihbc.kafka_example.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryRepository implements OrderRepositoryPort {

    private final Map<String, Order> ordersDataBase;
    private final Map<String, OrderEvent> orderEventDatabase;

    public InMemoryRepository(Map<String, Order> ordersDataBase, Map<String, OrderEvent> orderEventDatabase) {
        this.ordersDataBase = ordersDataBase;
        this.orderEventDatabase = orderEventDatabase;
    }

    @Override
    public String save(Order order) {
        String id = UUID.randomUUID().toString();
        this.ordersDataBase.put(id, order);
        return id;
    }

    @Override
    public String saveEvent(OrderEvent orderEvent) {
        String id = (orderEvent.getId() == null) ? UUID.randomUUID().toString() : orderEvent.getId();
        this.orderEventDatabase.put(id, orderEvent);
        return id;
    }

    @Override
    public Optional<Order> getById(String id) {
        return Optional.ofNullable(this.ordersDataBase.get(id));
    }
}
