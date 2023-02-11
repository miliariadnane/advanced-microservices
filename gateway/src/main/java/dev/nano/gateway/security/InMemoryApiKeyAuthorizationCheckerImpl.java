package dev.nano.gateway.security;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("inMemory-checker")
public class InMemoryApiKeyAuthorizationCheckerImpl implements ApiKeyAuthorizationChecker {

    private static Environment environment;

    public InMemoryApiKeyAuthorizationCheckerImpl(Environment environment) {
        this.environment = environment;
    }

    private static final String IN_MEMORY_API_KEY_1 = "API_KEY_1";
    private static final String IN_MEMORY_API_KEY_2 = "API_KEY_2";

    static String requiredProperty1 = environment.getRequiredProperty(IN_MEMORY_API_KEY_1);
    static String requiredProperty2 = environment.getRequiredProperty(IN_MEMORY_API_KEY_2);
    private static final Map<String, List<String>> apiKeys = Map.of(
            requiredProperty1, List.of("CUSTOMER", "PRODUCT", "NOTIFICATION"),
            requiredProperty2, List.of("PAYMENT", "ORDER")
    );

    @Override
    public boolean isAuthorized(String apiKey, String applicationName) {

        return apiKeys.getOrDefault(apiKeys, List.of())
                .stream()
                .anyMatch(a -> a.contains(applicationName));
    }
}