package dev.nano;

import dev.nano.apikey.ApiKeyRequest;
import dev.nano.apikey.ApiKeyService;
import dev.nano.application.ApplicationName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiKeyManagerDbSeeder {
    @Bean
    CommandLineRunner commandLineRunner(ApiKeyService apiKeyService) {
        return args -> {
            ApiKeyRequest apiKeyRequest = new ApiKeyRequest(
                    "foo", "bar", List.of(ApplicationName.CUSTOMER, ApplicationName.PRODUCT)
            );
            String apiKey = apiKeyService.save(apiKeyRequest);
            System.out.println(apiKey);
            System.out.println(apiKeyRequest);
        };
    }
}
