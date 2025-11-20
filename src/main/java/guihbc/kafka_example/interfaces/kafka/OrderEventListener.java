package guihbc.kafka_example.interfaces.kafka;

import guihbc.kafka_example.application.usecase.OrderEventUseCase;
import guihbc.kafka_example.domain.events.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {

    private final OrderEventUseCase orderEventUseCase;

    public OrderEventListener(OrderEventUseCase orderEventUseCase) {
        this.orderEventUseCase = orderEventUseCase;
    }

    @KafkaListener(topics = { "orders.events.v1" }, groupId = "kafka-example-application")
    public void listenOrderEvent(OrderEvent message) {
        System.out.println("Event " + message.getEventType().name() + " consumed for order ID: " + message.getOrderId());
        this.orderEventUseCase.saveOrderEvent(message);
    }
}
