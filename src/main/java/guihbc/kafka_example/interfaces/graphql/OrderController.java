package guihbc.kafka_example.interfaces.graphql;

import java.util.List;
import guihbc.kafka_example.application.dto.order.CreateOrderInput;
import guihbc.kafka_example.application.dto.order.OrderOutput;
import guihbc.kafka_example.application.usecase.OrderEventUseCase;
import guihbc.kafka_example.application.usecase.OrderUseCase;
import guihbc.kafka_example.domain.events.OrderEvent;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    private final OrderUseCase orderUseCase;
    private final OrderEventUseCase orderEventUseCase;

    public OrderController(OrderUseCase orderUseCase, OrderEventUseCase orderEventUseCase) {
        this.orderUseCase = orderUseCase;
        this.orderEventUseCase = orderEventUseCase;
    }

    @MutationMapping
    public OrderOutput createOrder(@Argument CreateOrderInput input) {
        return this.orderUseCase.createOrder(input);
    }

    @QueryMapping
    public OrderOutput getOrderById(@Argument String id) {
        return this.orderUseCase.getOrderById(id);
    }

    @QueryMapping
    public List<OrderEvent> getOrderEventsByOrderId(@Argument String orderId) {
        return this.orderEventUseCase.getOrderEventsByOrderId(orderId);
    }
}
