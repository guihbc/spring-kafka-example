package guihbc.kafka_example.application.dto.order;

public record ProductInput(
        String id,
        String name,
        Integer quantity,
        Integer total,
        Integer totalWithoutDiscount,
        Integer discount
) {}
