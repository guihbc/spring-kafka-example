package guihbc.kafka_example.application.dto.order;

public record DeliveryAddressInput(
        String street,
        String neighborhood,
        Integer number,
        String zipcode,
        String city,
        String state,
        String complement
) {}
