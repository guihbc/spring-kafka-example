package guihbc.kafka_example.application.mapper;

import guihbc.kafka_example.application.dto.order.DeliveryAddressInput;
import guihbc.kafka_example.domain.order.DeliveryAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeliveryAddressMapperTest {

    @Test
    void shouldMapDeliveryAddressInputToDomain() {
        // given
        DeliveryAddressInput input = new DeliveryAddressInput(
                "Main Street",
                "Downtown",
                123,
                "12345-678",
                "New York",
                "NY",
                "Apartment 10"
        );

        // when
        DeliveryAddress result = DeliveryAddressMapper.toDomain(input);

        // then
        assertNotNull(result);
        assertEquals("Main Street", result.street());
        assertEquals("Downtown", result.neighborhood());
        assertEquals(123, result.number());
        assertEquals("12345-678", result.zipcode());
        assertEquals("New York", result.city());
        assertEquals("NY", result.state());
        assertEquals("Apartment 10", result.complement());
    }
}