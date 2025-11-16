package guihbc.kafka_example.domain.order;

public record Product(
    String id,
    String name,
    Integer quantity,
    Integer total,
    Integer totalWithoutDiscount,
    Integer discount
) {}
