package org.example.players.server.service;

import jakarta.transaction.Transactional;
import org.example.players.server.assembler.PlayerModelAssembler;
import org.example.players.server.exception.EntityNotFoundException;
import org.example.players.server.entity.PlayerEntity;
import org.example.players.server.repositories.PlayerJpaRepository;
import org.example.players.server.repositories.PlayerPagingAndSortingRepository;
import org.example.players.server.service.parser.PlayerReader;
import org.example.players.server.service.parser.PlayerReaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayerReaderFactory _playerReaderFactory;

    @Autowired
    private PlayerJpaRepository _playerJpaDao;

    @Autowired
    private PlayerPagingAndSortingRepository _playerPgnDao;

    @PostConstruct
    @Transactional
    private void initPlayers() {
        String resourceName = "Player.csv";
        _logger.trace("Initializing Players database from resource [{}]", resourceName);
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            PlayerReader reader = _playerReaderFactory.create("CSV");
            List<PlayerEntity> playerEntities = reader.readAllPlayers(is);
            _playerJpaDao.saveAll(playerEntities);
            _logger.info("Players database initialized with [{}] entities.", playerEntities.size());
        } catch (IOException e) {
            _logger.error("Failed initializing Players database from resource file [{}]", resourceName);
        }
    }

    @Transactional
    public List<PlayerEntity> listPlayers() {
        _logger.warn("Listing All Players. This method should not be used!");
        return _playerJpaDao
                .findAll()
                .stream()
                .toList();
    }

    @Transactional
    public PlayerEntity getPlayer(String playerId) {
        _logger.trace("Retrieving Player with ID [{}]", playerId);
        Optional<PlayerEntity> entity = _playerJpaDao.findById(playerId);
        if(entity.isPresent()) {
            _logger.trace("Found Player with ID [{}]", playerId);
            return entity.get();
        } else {
            _logger.error("Player with ID [{}] not found", playerId);
            throw new EntityNotFoundException("Player", playerId);
        }
    }

    @Transactional
    public Page<PlayerEntity> getPlayersPage(Pageable pageable) {
        _logger.trace("Getting Page {} of {} Players. Offset {}.", pageable.getPageNumber(), pageable.getPageSize(), pageable.getOffset());
        return _playerPgnDao.findAll(pageable);
    }
}
