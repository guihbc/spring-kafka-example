package guihbc.kafka_example.application.dto.order;

import guihbc.kafka_example.domain.order.Order;

public class OrderOutput extends Order {
    public OrderOutput() {
        super();
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
