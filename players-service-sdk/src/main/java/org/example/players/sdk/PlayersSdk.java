package org.example.players.sdk;

import org.example.players.model.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.text.MessageFormat;

public class PlayersSdk extends BaseSdk implements IPlayersSdk {

    public PlayersSdk(String serviceUrl) {
        super(serviceUrl);
    }

    public PlayersSdk(String ip, int port) {
        this(MessageFormat.format("{0}{1}:{2}", ip.contains("//") ? "" : "http://", ip, Integer.toString(port)));
    }

    @Override
    public Player getPlayerById(String playerId) {
        String url = MessageFormat.format("{0}/players/{1}", _apiEndpoint, playerId);
        try {
            ResponseEntity<Player> responseEntity = sendRequest(url, HttpMethod.GET, new HttpEntity(new HttpHeaders()), Player.class);
            return responseEntity.getBody();
        } catch (Exception exception) {
            return null;
        }

    }

    @Override
    public PagedModel<Player> getPlayersPageable(Pageable pageable) {
        String url = MessageFormat.format("{0}/players", _apiEndpoint);
        ResponseEntity<Object> responseEntity = sendRequest(url, HttpMethod.GET, new HttpEntity(new HttpHeaders()), Object.class);
        PagedModel<Player> body = (PagedModel<Player>)responseEntity.getBody();
        return body;
    }
}
