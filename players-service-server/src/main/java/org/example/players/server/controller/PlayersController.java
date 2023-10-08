package org.example.players.server.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.example.players.model.Player;
import org.example.players.server.assembler.PlayerModelAssembler;
import org.example.players.server.entity.PlayerEntity;
import org.example.players.server.service.PlayersService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController extends BaseController {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayersService _service;

    @Autowired
    private PlayerModelAssembler _playerModelAssembler;

    @Autowired
    private PagedResourcesAssembler<PlayerEntity> _pagedResourcesAssembler;

    @GetMapping("/{playerID}")
    @Schema
    public Player getPlayerById(@RequestParam("playerID") String playerId) {
        _logger.trace("Called GET Player {}", playerId);
        PlayerEntity playerEntity = _service.getPlayer(playerId);
        return _playerModelAssembler.toModel(playerEntity);
    }

    @GetMapping
    @PageableAsQueryParam
    public PagedModel<Player> getPlayersPageable(@Parameter(hidden=true) Pageable pageable) {
        _logger.trace("Called GET Players Page {}. Size {}, Offset {}.", pageable.getPageNumber(), pageable.getPageSize(), pageable.getOffset());
        Page<PlayerEntity> entities = _service.getPlayersPage(pageable);
        return _pagedResourcesAssembler.toModel(entities, _playerModelAssembler);
    }

//    @GetMapping("/all")
//    @Schema
    public List<Player> getAllPlayers() {
        _logger.warn("Called GET All Players. Ths method is prohibited to use.");
        return _service
                .listPlayers()
                .stream()
                .map(_playerModelAssembler::toModel)
                .toList();
    }
}
