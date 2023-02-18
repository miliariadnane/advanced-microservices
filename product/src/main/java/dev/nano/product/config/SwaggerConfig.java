package dev.nano.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static dev.nano.payment.config.ConfigConstant.*;


@Configuration
@EnableSwagger2
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
                                new Contact(
                                        SWAGGER_CONFIG_CONTACT_NAME,
                                        SWAGGER_CONFIG_CONTACT_URL,
                                        SWAGGER_CONFIG_CONTACT_EMAIL), null, null));
    }
}
