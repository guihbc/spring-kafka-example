## Contents

- `Kafka` - overview and key concepts
- `GraphQL` - overview and key concepts
- How this project uses Kafka and GraphQL (quick pointers)

---

## Kafka - overview and key concepts

Apache Kafka is a distributed streaming platform used for building real-time event-driven systems. It provides durable, ordered, and scalable message streams. Here are the core concepts you should know:

- `Broker`: A running Kafka server (process) which stores and serves messages. A Kafka cluster is made of one or more brokers.
- `Topic`: A named stream of messages. Producers write messages to topics, and consumers read messages from topics.
- `Partition`: Topics are split into partitions. Each partition is an ordered, immutable sequence of messages that is continually appended to. Partitions enable parallelism and scale.
- `Offset`: A unique sequential id assigned to messages within a partition. The offset identifies the position of a consumer in the partition.
- `Producer`: An application that publishes (writes) messages to Kafka topics.
- `Consumer`: An application that subscribes to topics and processes messages.
- `Consumer group`: A group of consumers that coordinate to read a topic’s partitions so each partition is processed by only one consumer in the group. Consumer groups provide scalability and fault tolerance for message processing.
- `Retention`: Kafka stores messages for a configurable retention period or until a size threshold is reached. Consumers manage their own offsets; they may re-read older messages within retention.
- `Ordering guarantees`: Kafka provides ordering within a partition. If global ordering is required, the topic should have a single partition (which limits throughput).

- Delivery semantics:
  - `At-most-once`: Messages may be lost but are never redelivered.
  - `At-least-once`: Messages are retried and may be delivered more than once (duplicates possible).
  - `Exactly-once`: Achievable with Kafka transaction support and careful idempotent processing. More complex but possible for many use cases.

- `Use cases`: event sourcing, activity streams, decoupling microservices, log aggregation, streaming ETL.

Tips for designing with Kafka:
- Choose partition keys carefully to balance throughput and ordering requirements.
- Make consumers idempotent when `at-least-once` is used.
- Monitor consumer lag (difference between latest offset and consumer offset) to detect slow processing.

---

## GraphQL - overview and key concepts

GraphQL is a query language and runtime for APIs that gives clients the power to request exactly the data they need. It is commonly served over HTTP but can be used over many transports (including WebSockets for subscriptions).

Key concepts:

- `Schema`: A contract that describes the types, queries, mutations, and subscriptions supported by the API. The schema is strongly typed and self-documenting.
- `Query`: A read operation. Clients specify the shape of the data they want and receive a JSON response matching that shape.
- `Mutation`: A write operation (create/update/delete). Mutations are executed server-side and typically return the updated data.
- `Subscription`: A long-lived operation used to receive real-time updates (often implemented over WebSockets).
- `Type`: The building blocks of the schema (object types, scalar types, enums, input types, etc.).
- `Resolver`: Server-side functions that fetch or compute data for fields. Each field in the schema can have a resolver.

- Advantages vs REST:
  - Single endpoint that exposes a typed graph of data.
  - Clients control precisely what fields they receive, reducing over-fetching.
  - Strong typing enables better tooling (introspection, codegen, IDE autocompletion).

- Considerations and best practices:
  - Avoid overly complex resolvers that cause N+1 query problems; use dataloader/batching where needed.
  - Use pagination (cursor-based is common) for list fields.
  - Apply authentication/authorization in resolvers or a middleware layer.
  - Carefully design the schema while keeping client needs and performance in mind.

---

## How this project uses Kafka and GraphQL

This example project demonstrates both components working together:

- Kafka is used for internal event propagation. Look for Kafka configuration and ports under:
  - `src/main/java/guihbc/kafka_example/infrastructure/config/KafkaConfig.java`
  - Publisher and listener ports are implemented under the `infrastructure/kafka` and `interfaces/kafka` packages (for example, `KafkaEventPublisherPort` and `OrderEventListener`).

- GraphQL exposes an API for creating and querying domain objects (orders). The GraphQL schema file is at:
  - `src/main/resources/graphql/order.graphqls`
  - GraphQL server wiring is in `src/main/java/guihbc/kafka_example/infrastructure/config/GraphQLConfig.java` and the controller is under `interfaces/graphql`.

Typical flow in this repo:
- A client issues a GraphQL mutation (for example, to create an order).
- The application logic persists the order (in-memory for the example) and publishes an Order event to Kafka.
- A Kafka consumer (listener) receives order events and can perform further processing (logging, enrichment, downstream actions).

This pattern decouples the API surface from asynchronous processing and lets other services subscribe to order events without changing the API code.
