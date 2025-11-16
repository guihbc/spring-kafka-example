package guihbc.kafka_example.domain.order;

import java.time.OffsetDateTime;
import java.util.List;

public class Order {
    private String userId;
    private OrderStatus status;
    private Integer total;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime expectedDeliveryDate;
    private OffsetDateTime deliveredAt;
    private List<Product> products;
    private DeliveryAddress deliveryAddress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(OffsetDateTime expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public OffsetDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(OffsetDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
