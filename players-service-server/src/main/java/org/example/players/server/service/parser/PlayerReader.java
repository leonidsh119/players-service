package org.example.players.server.service.parser;

import org.example.players.server.entity.PlayerEntity;

import java.io.InputStream;
import java.util.List;

public interface PlayerReader {
    List<PlayerEntity> readAllPlayers(InputStream is);
}
