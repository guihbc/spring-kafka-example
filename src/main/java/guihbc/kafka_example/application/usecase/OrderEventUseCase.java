package guihbc.kafka_example.application.usecase;

import guihbc.kafka_example.application.ports.OrderRepositoryPort;
import guihbc.kafka_example.domain.events.OrderEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventUseCase {
    private final OrderRepositoryPort orderRepositoryPort;

    public OrderEventUseCase(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    public void saveOrderEvent(OrderEvent event) {
        this.orderRepositoryPort.saveEvent(event);
        System.out.println("Event " + event.getEventType().name() + " saved for order ID: " + event.getOrderId());
    }

    public List<OrderEvent> getOrderEventsByOrderId(String orderId) {
        return this.orderRepositoryPort.getOrderEventByOrderId(orderId);
    }
}
