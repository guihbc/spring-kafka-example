package guihbc.kafka_example.interfaces.graphql;

import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.application.ports.KafkaEventPublisher;
import guihbc.kafka_example.domain.events.OrderEvent;
import guihbc.kafka_example.domain.events.OrderEventType;
import guihbc.kafka_example.domain.order.Order;
import guihbc.kafka_example.domain.order.OrderStatus;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;

@Controller
public class OrderController {

    private final KafkaEventPublisher kafkaEventPublisher;

    public OrderController(KafkaEventPublisher kafkaEventPublisher) {
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    @MutationMapping
    public OrderOutput createOrder(@Argument CreateOrderInput input) {
        System.out.println(input.userId());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setEventType(OrderEventType.getEventTypeByOrderStatus(OrderStatus.CREATED));
        orderEvent.setData(new Order());
        orderEvent.setTimestamps(OffsetDateTime.now());

        kafkaEventPublisher.publish("orders.events.v1", orderEvent);
        return null;
    }
}
