package org.example.players.server.controller;

import org.example.players.sdk.Player;
import org.example.players.server.assembler.PlayerModelAssembler;
import org.example.players.server.entity.PlayerEntity;
import org.example.players.server.service.PlayersService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController extends BaseController {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayersService _service;

    @Autowired
    private PlayerModelAssembler _assembler;

    @GetMapping
    @Schema
    List<Player> listPlayers() {
        return _service.listPlayers();
    }

    @GetMapping("/{playerID}")
    @Schema
    public Player getPlayerById(@RequestParam("playerID") String playerId) {
        return _service.getPlayer(playerId);
    }

    @GetMapping("/pagination")
    public ResponseEntity<PagedModel<Player>> getAllPlayers(Pageable pageable)
    {
        Page<PlayerEntity> playerEntities = _service.listPlayers(pageable);
        PagedModel<Player> pagedModel = _assembler.toModel(playerEntities);
        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
        return null;
    }
}
