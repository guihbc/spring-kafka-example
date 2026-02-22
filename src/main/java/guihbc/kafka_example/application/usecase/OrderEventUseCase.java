package guihbc.kafka_example.application.usecase;

import guihbc.kafka_example.application.ports.OrderRepositoryPort;
import guihbc.kafka_example.domain.events.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private static final Logger logger = LoggerFactory.getLogger(OrderEventUseCase.class);

    public OrderEventUseCase(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    public void saveOrderEvent(OrderEvent event) {
        this.orderRepositoryPort.saveEvent(event);
        logger.info("Event {} saved for order ID: {}", event.getEventType().name(), event.getOrderId());
    }

    public List<OrderEvent> getOrderEventsByOrderId(String orderId) {
        return this.orderRepositoryPort.getOrderEventByOrderId(orderId);
    }
}
