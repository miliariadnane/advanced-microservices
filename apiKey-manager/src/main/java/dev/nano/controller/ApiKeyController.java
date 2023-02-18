package dev.nano.controller;

import dev.nano.apikey.ApiKeyConstant;
import dev.nano.apikey.ApiKeyRequest;
import dev.nano.apikey.ApiKeyService;
import dev.nano.application.ApplicationName;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = ApiKeyConstant.API_KEY_URI_REST_API)
@AllArgsConstructor @Slf4j
public class ApiKeyController {
    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<String> generateNewApiKey(
            @RequestBody ApiKeyRequest apiKeyRequest) {
        return ResponseEntity.ok(apiKeyService.save(apiKeyRequest));
    }

    @PutMapping("{apiKey}/revoke")
    public void revokeKey(@PathVariable("apiKey") String apiKey) {
        apiKeyService.revokeApi(apiKey);
    }

    @GetMapping("{apiKey}/applications/{applicationName}/authorization")
    public ResponseEntity<Boolean> isKeyAuthorizedForApplication(
            @PathVariable("apiKey") String apiKey,
            @PathVariable("applicationName") ApplicationName applicationName) {
        return ResponseEntity.ok(apiKeyService.isAuthorized(apiKey, applicationName));
    }
}
