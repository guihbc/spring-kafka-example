package guihbc.kafka_example.application.mapper;

import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.domain.order.Order;
import guihbc.kafka_example.domain.order.OrderStatus;

public abstract class OrderMapper {

    public static Order createOrderDtoToDomain(CreateOrderInput orderInput) {
        Order order = new Order();
        order.setUserId(orderInput.userId());
        order.setStatus(OrderStatus.CREATED);
        order.setExpectedDeliveryDate(orderInput.expectedDeliveryDate());
        order.setProducts(ProductMapper.listToDomain(orderInput.products()));
        order.setDeliveryAddress(DeliveryAddressMapper.toDomain(orderInput.deliveryAddress()));

        return order;
    }

    public static OrderOutput toOrderOutput(String id, Order order) {
        if (order == null) {
            return null;
        }

        OrderOutput output = new OrderOutput();
        output.setId(id);
        output.setUserId(order.getUserId());
        output.setCreatedAt(order.getCreatedAt());
        output.setUpdatedAt(order.getUpdatedAt());
        output.setProducts(order.getProducts());
        output.setStatus(order.getStatus());
        output.setDeliveredAt(order.getDeliveredAt());
        output.setDeliveryAddress(order.getDeliveryAddress());
        output.setExpectedDeliveryDate(order.getExpectedDeliveryDate());
        output.setTotal(order.getTotal());
        return output;
    }
}
