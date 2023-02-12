package dev.nano.application;

import dev.nano.apikey.ApiKeyEntity;
import dev.nano.apikey.ApiKeyRepository;
import dev.nano.exception.domain.apiKeyManager.ApiKeyNotFoundException;
import dev.nano.exception.domain.apiKeyManager.ApplicationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.nano.exception.constant.ExceptionConstant.API_KEY_NOT_FOUND_EXCEPTION_MESSAGE;
import static dev.nano.exception.constant.ExceptionConstant.APPLICATION_NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
    private final ApplicationRepository applicationRepository;
    private final ApiKeyRepository apiKeyRepository;
    @Override
    public void assignApplicationToApiKey(ApplicationName applicationName, String apiKey) {
        ApiKeyEntity key = apiKeyRepository.findByKey(apiKey)
                .orElseThrow(() -> new ApiKeyNotFoundException(API_KEY_NOT_FOUND_EXCEPTION_MESSAGE));

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
            throw new ApiKeyNotFoundException(API_KEY_NOT_FOUND_EXCEPTION_MESSAGE);

        ApplicationEntity application = applicationRepository.findByName(applicationName)
                .orElseThrow(() -> new ApplicationNotFoundException(APPLICATION_NOT_FOUND_EXCEPTION_MESSAGE));

        application.setRevoked(true);
        application.setEnabled(false);
        application.setApproved(false);

        applicationRepository.save(application);
    }
}
