package guihbc.kafka_example.interfaces.kafka;

import guihbc.kafka_example.application.usecase.OrderEventUseCase;
import guihbc.kafka_example.domain.events.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {

    private final OrderEventUseCase orderEventUseCase;
    private static final Logger logger = LoggerFactory.getLogger(OrderEventListener.class);

    public OrderEventListener(OrderEventUseCase orderEventUseCase) {
        this.orderEventUseCase = orderEventUseCase;
    }

    @KafkaListener(topics = { "orders.events.v1" }, groupId = "kafka-example-application")
    public void listenOrderEvent(OrderEvent message) {
        logger.info("Event {} consumed for order ID: {}", message.getEventType().name(), message.getOrderId());
        this.orderEventUseCase.saveOrderEvent(message);
    }
}
