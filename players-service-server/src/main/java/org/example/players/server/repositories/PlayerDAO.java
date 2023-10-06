package org.example.players.server.repositories;

import org.example.players.server.model.PlayerEntity;

import java.util.List;

public interface PlayerDAO {
    PlayerEntity getById(String playerId);

    List<PlayerEntity> get(String sortBy, int size, int offset);

    void save(PlayerEntity entity);

    void save(List<PlayerEntity> entities);

    int count();
}
