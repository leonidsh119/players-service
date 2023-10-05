package org.example.players.sdk;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

public class GraphSdk implements IGraphSdk {
    private final RestTemplate _restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    private String _apiEndpoint;

    public GraphSdk(String serviceUrl) {
        _apiEndpoint = MessageFormat.format("{0}/players", serviceUrl);
    }

    public GraphSdk(String ip, int port) {
        this(MessageFormat.format("{0}{1}:{2}", ip.contains("//") ? "" : "http://", ip, Integer.toString(port)));
    }

    @Override
    public String findUnreachableNodes(FindUnreachableNodesRequest request) {
        String url = MessageFormat.format("{0}/algo", _apiEndpoint);
        ResponseEntity<String> responseEntity = sendRequest(url, HttpMethod.POST, new HttpEntity<>(request), String.class);
        return responseEntity.getBody();
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

    private <T> ResponseEntity<T> sendRequest(String url, HttpMethod method, Class<T> responseType) {
        return this.sendRequest(url, method, (HttpEntity)null, responseType);
    }

    private <T> ResponseEntity<T> sendRequest(String url, HttpMethod method, HttpEntity<?> entity, Class<T> responseType) {
        return _restTemplate.exchange(url, method, entity, responseType);
        // TODO: Handle errors
    }
}
