package guihbc.kafka_example.interfaces.graphql;

import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.domain.order.DeliveryAddress;
import guihbc.kafka_example.domain.order.OrderStatus;
import guihbc.kafka_example.domain.order.Product;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    @MutationMapping
    public OrderOutput createOrder(@Argument CreateOrderInput input) {
        System.out.println(input.userId());

        Product product1 = new Product("p1", "Mouse", 2, 200, 220, 20);
        Product product2 = new Product("p2", "Keyboard", 1, 150, 150, 0);
        List<Product> products = List.of(product1, product2);

        DeliveryAddress address = new DeliveryAddress(
                "Rua A",
                "Centro",
                123,
                "12345678",
                "Florianópolis",
                "SC",
                "Apto 101"
        );

        OrderOutput order = new OrderOutput();
        order.setId(UUID.randomUUID().toString());
        order.setUserId("user-123");
        order.setStatus(OrderStatus.CREATED);
        order.setTotal(350);
        order.setCreatedAt("2025-11-15T10:00:00");
        order.setUpdatedAt("2025-11-15T10:00:00");
        order.setExpectedDeliveryDate("2025-11-25");
        order.setDeliveredAt("2025-11-26");
        order.setProducts(products);
        order.setDeliveryAddress(address);

        return order;
    }
}
