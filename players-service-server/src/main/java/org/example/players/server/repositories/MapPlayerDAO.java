package org.example.players.server.repositories;

import org.example.players.server.data.PlayerMap;
import org.example.players.server.model.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MapPlayerDAO implements PlayerDAO {
    @Autowired
    private PlayerMap _players;

    @Override
    public PlayerEntity getById(String playerId) {
        return null;
    }

    @Override
    public List<PlayerEntity> get(String sortBy, int size, int offset) {
        return _players
                .getPlayers()
                .sorted() // TODO: Check how it works
                .skip(offset)
                .limit(size)
                .toList();
    }

    @Override
    public void save(PlayerEntity entity) {
        if(entity != null) {
            _players.add(entity);
        }
    }

    @Override
    public void save(List<PlayerEntity> entities) {
        if(entities != null) {
            entities.forEach(_players::add);
        }
    }

    @Override
    public int count() {
        return _players.count();
    }
}
