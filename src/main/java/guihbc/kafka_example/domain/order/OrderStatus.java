package guihbc.kafka_example.domain.order;

public enum OrderStatus {
    CREATED,
    WAITING_PAYMENT,
    PAYED,
    PREPARING,
    IN_TRANSIT,
    DELIVERED,
    CANCELLED,
}
