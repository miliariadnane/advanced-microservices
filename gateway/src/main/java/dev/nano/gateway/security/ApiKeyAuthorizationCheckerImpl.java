package dev.nano.gateway.security;

import org.springframework.stereotype.Service;

@Service("main-checker")
public class ApiKeyAuthorizationCheckerImpl implements ApiKeyAuthorizationChecker {
    @Override
    public boolean isAuthorized(String apiKey, String applicationName) {
        return true;
    }
}
