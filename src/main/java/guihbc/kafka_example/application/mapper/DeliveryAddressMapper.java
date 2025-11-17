package guihbc.kafka_example.application.mapper;

import guihbc.kafka_example.application.dto.order.DeliveryAddressInput;
import guihbc.kafka_example.domain.order.DeliveryAddress;

public abstract class DeliveryAddressMapper {

    public static DeliveryAddress toDomain(DeliveryAddressInput input) {
       return new DeliveryAddress(
                input.street(),
                input.neighborhood(),
                input.number(),
                input.zipcode(),
                input.city(),
                input.state(),
                input.complement());
    }
}
