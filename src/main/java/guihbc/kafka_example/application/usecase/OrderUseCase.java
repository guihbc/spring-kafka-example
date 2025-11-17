package guihbc.kafka_example.application.usecase;

import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.application.dto.order.ProductInput;
import guihbc.kafka_example.application.mapper.OrderMapper;
import guihbc.kafka_example.application.ports.KafkaEventPublisherPort;
import guihbc.kafka_example.application.ports.OrderRepositoryPort;
import guihbc.kafka_example.domain.events.OrderEvent;
import guihbc.kafka_example.domain.events.OrderEventType;
import guihbc.kafka_example.domain.order.Order;
import guihbc.kafka_example.domain.order.OrderStatus;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OrderUseCase {

    private final KafkaEventPublisherPort kafkaEventPublisherPort;
    private final OrderRepositoryPort orderRepositoryPort;

    public OrderUseCase(KafkaEventPublisherPort kafkaEventPublisherPort, OrderRepositoryPort orderRepositoryPort) {
        this.kafkaEventPublisherPort = kafkaEventPublisherPort;
        this.orderRepositoryPort = orderRepositoryPort;
    }

    public OrderOutput createOrder(CreateOrderInput input) {
        Order order = this.buildCreatedOrder(input);
        String id = this.orderRepositoryPort.save(order);

        OrderEvent orderEvent = this.buildEvent(id, order);
        kafkaEventPublisherPort.publish("orders.events.v1", orderEvent);
        return OrderMapper.toOrderOutput(id, order);
    }

    private Order buildCreatedOrder(CreateOrderInput input) {
        Order order = OrderMapper.createOrderDtoToDomain(input);
        order.setTotal(this.calculateTotal(input.products()));
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(OffsetDateTime.now());
        order.setUpdatedAt(OffsetDateTime.now());
        return order;
    }

    private OrderEvent buildEvent(final String id, final Order order) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setId(id);
        orderEvent.setEventType(OrderEventType.getEventTypeByOrderStatus(order.getStatus()));
        orderEvent.setData(order);
        orderEvent.setTimestamp(OffsetDateTime.now());

        return orderEvent;
    }

    private Integer calculateTotal(List<ProductInput> productsInput) {
        return productsInput.stream().mapToInt(ProductInput::total).sum();
    }
}
