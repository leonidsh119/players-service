package org.example.players.server.service;

import org.example.players.sdk.Player;
import org.example.players.server.model.PlayerEntity;
import org.example.players.server.service.parser.PlayerReader;
import org.example.players.server.service.parser.PlayerReaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayersService {
    private final Logger _logger = LoggerFactory.getLogger(getClass());
    private Map<String, PlayerEntity> _players;

    @Autowired
    PlayerReaderFactory _playerReaderFactory;

    @PostConstruct
    private void initPlayers() {
        String resourceName = "Player.csv";
        _logger.trace("Initializing Players database from resource [{}]", resourceName);
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            PlayerReader reader = _playerReaderFactory.create("CSV");
            List<PlayerEntity> players = reader.readAllPlayers(is);
            _players = players.stream().collect(Collectors.toMap(PlayerEntity::getPlayerID, player -> player));
            _logger.info("Players database initialized with [{}] entities.", _players.size());
        } catch (IOException e) {
            _logger.error("Failed initializing Players database from resource file [{}]", resourceName);
        }
    }

    public List<Player> listPlayers() {
        _logger.trace("Listing All Players");
        return _players.values().stream().map(this::toResponse).toList();
    }

    public Player getPlayer(String playerId) {
        return toResponse(_players.get(playerId));
    }

    public Player toResponse(PlayerEntity player) {
        return new Player(player.getPlayerID())
                .withBirthYear(player.getBirthYear())
                .withBirthMonth(player.getBirthMonth())
                .withBirthDay(player.getBirthDay())
                .withBirthCountry(player.getBirthCountry())
                .withBirthState(player.getBirthState())
                .withBirthCity(player.getBirthCity())
                .withDeathYear(player.getDeathYear())
                .withDeathMonth(player.getDeathMonth())
                .withDeathDay(player.getDeathDay())
                .withDeathCountry(player.getDeathCountry())
                .withDeathState(player.getDeathState())
                .withDeathCity(player.getDeathCity())
                .withNameFirst(player.getNameFirst())
                .withNameLast(player.getNameLast())
                .withNameGiven(player.getNameGiven())
                .withWeight(player.getWeight())
                .withHeight(player.getHeight())
                .withBats(player.getBats())
                .withThrowz(player.getThrowz())
                .withDebut(player.getDebut())
                .withFinalGame(player.getFinalGame())
                .withRetroID(player.getRetroID())
                .withBbrefID(player.getBbrefID());
    }
}
