package org.example.players.server.data;

import org.example.players.server.model.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PlayerMap {
    private final Map<String, PlayerEntity> _players = new HashMap<>();

    public void add(PlayerEntity entity) {
        _players.put(entity.getPlayerID(), entity);
    }

    public PlayerEntity getPlayer(String playerId) {
        return _players.get(playerId);
    }

    public Stream<PlayerEntity> getPlayers() {
        return _players.values().stream();
    }

    public int count() {
        return _players.size();
    }
}
