# ๐งบ Sample Store App With Microservice Architecture ๐งบ 

> A practical sample store, built with spring frameworks, kubernetes and deployed on AWS. This is an advanced part based on my previous project [demo-microservices](https://github.com/miliariadnane/demo-microservices) in which I'm focusing on security concerns, resiliency, observability and deployment improvements.

๐ก This application is not business oriented and my focus is mostly on technical part, I just want to implement a sample app from scratch with microservice architecture using different technologies, principles and patterns.

๐ This Application is `in-progress` and I will add new features over time. ๐

## Guide & Documentation

๐ Coming soon ... ๐

## Support

If you like my work, feel free to:

- โญ this repository. And we will be happy together :)

Thanks a bunch for supporting me!

## Features
- โ Using `Postgres` and `PgAdmin` for database and database management system.
- โ Using docker and `docker-compose` for running the application on local machine, docker, kubernetes and AWS environment.
- โ Using `Event Driven Architecture` on top of RabbitMQ Message Broker.
- โ Using `Prometheus` and `Grafana` for monitoring and metrics.
- โ Using `Sleuth` and `Zipkin` for distributed tracing and logging.
- โ Using `Service Discovery` with `Eureka server` for local development and `Kubernetes` service discovery for production environment.
- โ Using `API Gateway` with `Spring Cloud Gateway` for local development and `Kubernetes load balancer` for production environment.
- โ Using `AWS SES` service for sending emails.

## Roadmap
- ๐ง Add `Api Key Management` with `Keycloak` for security and authentication.
- ๐ง Using `Helm` or `Kustomize` for deploying the application on `Kubernetes` cluster.
- ๐ง Add `Resilience4j` for circuit breaker and fallback.
- ๐ง Add log aggregation with `ELK` stack.
- ๐ง Create frontend application with `React` / `Angular`.
- ๐ง Add `Istio` for service mesh.

## Technologies - Libraries

- โ๏ธ **[`eureka-server-discovery`](https://spring.io/guides/gs/service-registration-and-discovery/)** - Eureka is a service registry for resilient spring microservices.
- โ๏ธ **[`spring-cloud-gateway`](https://cloud.spring.io/spring-cloud-gateway/reference/html/)** - Spring Cloud Gateway is a non-blocking, reactive, based on Spring 5, web server gateway.
- โ๏ธ **[`spring-cloud-loadbalancer`](https://spring.io/guides/gs/spring-cloud-loadbalancer/)** - Spring Cloud LoadBalancer is a library that provides a common abstraction over client-side load balancing.
- โ๏ธ **[`sleuth-zipkin`](https://cloud.spring.io/spring-cloud-sleuth/reference/html/)** - Distributed tracing with Zipkin and Spring Cloud Sleuth.
- โ๏ธ **[`open-feign`](https://cloud.spring.io/spring-cloud-openfeign/reference/html/)** - Declarative REST Client for spring.
- โ๏ธ **[`spring-boot-starter-data-jpa`](https://spring.io/projects/spring-data-jpa)** - Spring Data JPA is a layer on top of the JPA API.
- โ๏ธ **[`lombok`](https://projectlombok.org/)** - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
- โ๏ธ **[`amqp-starter`](https://spring.io/projects/spring-amqp)** - Spring AMQP provides an abstraction layer for sending and receiving messages with a message broker.
- โ๏ธ **[`rabbitmq`](https://www.rabbitmq.com/)** - RabbitMQ is an open source message broker software that implements the Advanced Message Queuing Protocol (AMQP).
- โ๏ธ **[`mapstruct`](https://mapstruct.org/)** - MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.
- โ๏ธ **[`Junit5`](https://junit.org/junit5/)** - For unit testing and integration testing.
- โ๏ธ **[`Mockito`](https://site.mockito.org/)** - For mocking objects in unit tests.
- โ๏ธ **[`jib-plugin`](https://github.com/GoogleContainerTools/jib)** - Container image builder that facilitates building container images for your Java applications.
- โ๏ธ **[`docker-compose`](https://docs.docker.com/compose/)** - Compose is a tool for defining and running multi-container Docker applications.
- โ๏ธ **[`kubernetes`](https://kubernetes.io/)** - Kubernetes is an open-source system for automating deployment, scaling, and management of containerized applications.
- โ๏ธ **[`prometheus`](https://prometheus.io/)** - Prometheus is an open-source systems monitoring and alerting toolkit.
- โ๏ธ **[`grafana`](https://grafana.com/)** - Grafana is an open source, feature rich metrics dashboard and graph editor for Graphite, Elasticsearch, OpenTSDB, Prometheus and InfluxDB.
- โ๏ธ **[`AWS SES`](https://aws.amazon.com/ses/)** - Amazon Simple Email Service (Amazon SES) is a cloud-based email sending service.
- โ๏ธ **[`AWS EKS`](https://aws.amazon.com/eks/)** - Amazon Elastic Kubernetes Service (Amazon EKS) is a managed service that makes it easy for you to run Kubernetes on AWS without needing to install, operate, and maintain your own Kubernetes control plane.

## System Architecture

![](./assets/system-architecture-diagram.png)

## License
This project is made available under the MIT license. See [LICENSE](https://github.com/miliariadnane/advanced-microservices/blob/main/LICENSE) for details.

