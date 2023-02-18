package dev.nano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static dev.nano.config.ConfigConstant.*;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() throws IndexOutOfBoundsException {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_CONFIG_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build().apiInfo(
                        new ApiInfo(
                                SWAGGER_CONFIG_TITLE,
                                SWAGGER_CONFIG_DESCRIPTION,
                                SWAGGER_CONFIG_VERSION, null,
                                SWAGGER_CONTACT_CONTACT_NAME, null, null));
    }
}
