package dev.nano.apikey;

import dev.nano.application.ApplicationName;

public interface ApiKeyService {
    public String save(ApiKeyRequest apiKeyRequest);
    public void revokeApi(String key);
    public boolean isAuthorized(String apiKey, ApplicationName applicationName);
}
