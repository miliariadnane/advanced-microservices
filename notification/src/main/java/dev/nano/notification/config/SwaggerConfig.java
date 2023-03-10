package dev.nano.notification.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static dev.nano.notification.config.ConfigConstant.*;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(SWAGGER_GROUP_NAME)
                .packagesToScan(SWAGGER_CONFIG_BASE_PACKAGE)
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(SWAGGER_CONFIG_TITLE)
                        .description(SWAGGER_CONFIG_DESCRIPTION)
                        .version(SWAGGER_CONFIG_VERSION)
                        .contact(new Contact().name(SWAGGER_CONTACT_CONTACT_NAME))
                        .license(new License().name(SWAGGER_LICENSE_NAME).url(SWAGGER_LICENSE_URL)));
    }
}
