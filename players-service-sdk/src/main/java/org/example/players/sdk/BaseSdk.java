package org.example.players.sdk;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

public class BaseSdk implements IBaseSdk {
    private final RestTemplate _restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    protected String _apiEndpoint;

    public BaseSdk(String serviceUrl) {
        _apiEndpoint = MessageFormat.format("{0}/api", serviceUrl);
    }
    @Override
    public boolean healthCheck() {
        String url = MessageFormat.format("{0}/healthcheck", _apiEndpoint);
        try {
            ResponseEntity<Void> responseEntity = sendRequest(url, HttpMethod.GET, new HttpEntity(new HttpHeaders()), Void.class);
            return responseEntity.getStatusCode().equals(HttpStatus.OK);
        } catch (Exception e) {
            return false;
        }
    }

    protected <T> ResponseEntity<T> sendRequest(String url, HttpMethod method, Class<T> responseType) {
        return this.sendRequest(url, method, (HttpEntity)null, responseType);
    }

    protected <T> ResponseEntity<T> sendRequest(String url, HttpMethod method, HttpEntity<?> entity, Class<T> responseType) {
        return _restTemplate.exchange(url, method, entity, responseType);
        // TODO: Handle errors
    }
}
