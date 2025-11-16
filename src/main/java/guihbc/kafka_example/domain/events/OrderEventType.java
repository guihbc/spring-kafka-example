package guihbc.kafka_example.domain.events;

import guihbc.kafka_example.domain.order.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public enum OrderEventType {
    ORDER_CREATED,
    ORDER_UPDATED,
    ORDER_DELIVERED,
    ORDER_CANCELLED;

    public static OrderEventType getEventTypeByOrderStatus(OrderStatus orderStatus) {
        Map<OrderStatus, OrderEventType> eventsByOrderStatus = new HashMap<>();
        eventsByOrderStatus.put(OrderStatus.CREATED, ORDER_CREATED);
        eventsByOrderStatus.put(OrderStatus.DELIVERED, ORDER_DELIVERED);
        eventsByOrderStatus.put(OrderStatus.CANCELLED, ORDER_CANCELLED);

        OrderEventType event =  eventsByOrderStatus.get(orderStatus);
        return (event != null) ? event : ORDER_UPDATED;
    }
}
