package org.example.players.server.repositories;

import org.example.players.server.entity.PlayerEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerDAO {
    PlayerEntity getById(String playerId);

    List<PlayerEntity> get(Pageable pageable);

    void save(PlayerEntity entity);

    void save(List<PlayerEntity> entities);

    int count();
}
