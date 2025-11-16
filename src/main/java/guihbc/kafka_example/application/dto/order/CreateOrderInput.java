package guihbc.kafka_example.application.dto.order;

import guihbc.kafka_example.domain.order.OrderStatus;

import java.util.List;

public record CreateOrderInput(
    String userId,
    OrderStatus status,
    String expectedDeliveryDate,
    String deliveredAt,
    List<ProductInput> products,
    DeliveryAddressInput deliveryAddress
) {}
