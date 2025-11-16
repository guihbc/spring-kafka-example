package guihbc.kafka_example.domain.events;

import guihbc.kafka_example.domain.order.Order;

public class OrderEvent extends Event {
    public OrderEvent() {
        super();
    }

    private Order data;

    public Order getData() {
        return data;
    }

    public void setData(Order data) {
        this.data = data;
    }
}
