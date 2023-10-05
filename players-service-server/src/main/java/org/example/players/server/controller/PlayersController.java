package org.example.players.server.controller;

import org.example.players.sdk.Player;
import org.example.players.server.service.PlayersService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController extends BaseController {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayersService _service;

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
}
