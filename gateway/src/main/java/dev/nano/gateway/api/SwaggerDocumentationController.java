package dev.nano.gateway.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerDocumentationController implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(
                swaggerResource("customer", "/api/v1/customers/api-docs", "1.0"));
        resources.add(
                swaggerResource("order", "/api/v1/orders/api-docs", "1.0"));
        resources.add(
                swaggerResource("product", "/api/v1/products/api-docs", "1.0"));
        resources.add(
                swaggerResource("payment", "/api/v1/payments/api-docs", "1.0"));
        resources.add(
                swaggerResource("notification", "/api/v1/notifications/api-docs", "1.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
