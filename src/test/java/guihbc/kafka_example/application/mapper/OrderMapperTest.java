package guihbc.kafka_example.application.mapper;

import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.domain.order.DeliveryAddress;
import guihbc.kafka_example.domain.order.Order;
import guihbc.kafka_example.domain.order.OrderStatus;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderMapperTest {

    @Test
    void shouldMapDomainToOutput() {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(OffsetDateTime.now());
        order.setUpdatedAt(OffsetDateTime.now());
        order.setTotal(80000);
        order.setProducts(new ArrayList<>());
        order.setDeliveryAddress(new DeliveryAddress(
                "Street 1",
                "Neighborhood 1",
                123,
                "123456789",
                "City 1",
                "State 1",
                "Complement 1"
        ));
        order.setExpectedDeliveryDate(OffsetDateTime.now());
        order.setUserId("123");
        order.setDeliveredAt(OffsetDateTime.now());

        OrderOutput result = OrderMapper.toOrderOutput("123", order);

        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals(order.getStatus(), result.getStatus());
        assertEquals(order.getCreatedAt(), result.getCreatedAt());
        assertEquals(order.getUpdatedAt(), result.getUpdatedAt());
        assertEquals(order.getTotal(), result.getTotal());
    }
}
