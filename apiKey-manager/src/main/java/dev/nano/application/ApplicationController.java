package dev.nano.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = ApplicationConstant.APPLICATION_URI_REST_API)
@AllArgsConstructor @Slf4j
public class ApplicationController {
    private final ApplicationService applicationService;

    @DeleteMapping("{applicationName}/revoke/{apiKey}")
    public void revokeApplicationFromApiKey(
            @PathVariable("applicationName") String applicationName,
            @PathVariable("apiKey") String apiKey) {
        applicationService.revokeApplicationFromApiKey(applicationName, apiKey);
    }

    @PutMapping("{applicationName}/revoke/{apiKey}")
    public void assignApplicationToApiKey(
            @PathVariable("applicationName") ApplicationName applicationName,
            @PathVariable("apiKey") String apiKey) {
        applicationService.assignApplicationToApiKey(applicationName, apiKey);
    }
}
