package guihbc.kafka_example.application.mapper;

import guihbc.kafka_example.application.dto.order.ProductInput;
import guihbc.kafka_example.domain.order.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductMapper {

    private static Product toDomain(ProductInput input) {
        return new Product(
                input.id(),
                input.name(),
                input.quantity(),
                input.total(),
                input.totalWithoutDiscount(),
                input.discount());
    }

    public static List<Product> listToDomain(List<ProductInput> inputs) {
        List<Product> products = new ArrayList<>();
        inputs.forEach(input -> products.add(toDomain(input)));
        return products;
    }
}
