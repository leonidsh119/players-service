package org.example.players.server.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.example.players.sdk.Player;
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
    private PlayerModelAssembler playerModelAssembler;

    @Autowired
    private PagedResourcesAssembler<PlayerEntity> pagedResourcesAssembler;

    @GetMapping
    @Schema
    List<Player> listPlayers() {
        return _service.listPlayers();
    }

    @GetMapping("/{playerID}")
    @Schema
    Player getPlayer(@RequestParam("playerID") String playerId) {
        return _service.getPlayer(playerId);
    }

    @GetMapping("/page")
    @PageableAsQueryParam
    public PagedModel<Player> findAll(@Parameter(hidden=true) Pageable pageable) {
        Page<PlayerEntity> entities = _service.getPlayersPage(pageable);
        return pagedResourcesAssembler.toModel(entities, playerModelAssembler);
    }
}
