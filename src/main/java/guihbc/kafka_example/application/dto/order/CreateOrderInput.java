package guihbc.kafka_example.application.dto.order;

import java.time.OffsetDateTime;
import java.util.List;

public record CreateOrderInput(
    String userId,
    OffsetDateTime expectedDeliveryDate,
    OffsetDateTime deliveredAt,
    List<ProductInput> products,
    DeliveryAddressInput deliveryAddress
) {}
