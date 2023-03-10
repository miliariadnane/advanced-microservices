package dev.nano.gateway.security;

import dev.nano.clients.apiKeyManager.apiKey.ApiKeyManagerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("main-checker")
@AllArgsConstructor
public class ApiKeyAuthorizationCheckerImpl implements ApiKeyAuthorizationChecker {
    private final ApiKeyManagerClient apiKeyManagerClient;
    @Override
    public boolean isAuthorized(String apiKey, String applicationName) {
        return apiKeyManagerClient.isKeyAuthorizedForApplication(
                apiKey,
                applicationName
        ).isAuthorized();
    }
}
