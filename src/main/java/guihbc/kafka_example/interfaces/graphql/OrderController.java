package guihbc.kafka_example.interfaces.graphql;

import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @MutationMapping
    public OrderOutput createOrder(@Argument CreateOrderInput input) {
        System.out.println(input.userId());
        return null;
    }
}
