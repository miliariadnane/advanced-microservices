package dev.nano.application;

public interface ApplicationService {
    public void assignApplicationToApiKey(ApplicationName applicationName, String apiKey);
    public void revokeApplicationFromApiKey(String applicationName, String apiKey);
}
