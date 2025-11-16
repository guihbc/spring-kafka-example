package guihbc.kafka_example.domain.order;

public record DeliveryAddress(
    String street,
    String neighborhood,
    Integer number,
    String zipcode,
    String city,
    String state,
    String complement
) {}
