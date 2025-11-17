package guihbc.kafka_example.domain.events;

import java.time.OffsetDateTime;

public class Event {
    private String id;
    private OrderEventType eventType;
    private OffsetDateTime timestamps;

    public OrderEventType getEventType() {
        return eventType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventType(OrderEventType eventType) {
        this.eventType = eventType;
    }

    public OffsetDateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(OffsetDateTime timestamps) {
        this.timestamps = timestamps;
    }
}
