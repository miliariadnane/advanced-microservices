package dev.nano.application;

import dev.nano.apikey.ApiKeyEntity;
import dev.nano.apikey.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
    private final ApplicationRepository applicationRepository;
    private final ApiKeyRepository apiKeyRepository;
    @Override
    public void assignApplicationToApiKey(ApplicationName applicationName, String apiKey) {
        ApiKeyEntity key = apiKeyRepository.findByKey(apiKey)
                .orElseThrow(() -> new RuntimeException("Api key not found"));

        ApplicationEntity application = ApplicationEntity.builder()
                    .applicationName(applicationName)
                    .apiKey(key)
                    .revoked(false)
                    .enabled(true)
                    .approved(true)
                    .build();

        applicationRepository.save(application);
    }

    @Override
    public void revokeApplicationFromApiKey(String applicationName, String apiKey) {
        if(!apiKeyRepository.doesKeyExists(apiKey))
            throw new RuntimeException("Api key not found");

        ApplicationEntity application = applicationRepository.findByName(applicationName)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setRevoked(true);
        application.setEnabled(false);
        application.setApproved(false);

        applicationRepository.save(application);
    }
}
