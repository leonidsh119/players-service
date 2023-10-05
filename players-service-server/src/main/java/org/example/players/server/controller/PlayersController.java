package org.example.players.server.controller;

import org.example.players.sdk.FindUnreachableNodesRequest;
import org.example.players.sdk.Player;
import org.example.players.server.service.PlayersService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController extends BaseController {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlayersService _service;

    @PostMapping
    @Schema
    String findUnreachableEdges(@RequestBody FindUnreachableNodesRequest request) throws Exception {
        _logger.trace("Searching for unreachable nodes in graph [{}] from node [{}]", request.getGraph(), request.getE1());
        Iterable<String> unreachableNodes = _service.findUnreachableNodes(request.getE1(), request.getGraph());
        return String.format("{%s}", String.join(",", unreachableNodes));
    }

    @GetMapping
    @Schema
    List<Player> listPlayers() {
        return new ArrayList<Player>();
    }

    @GetMapping("/{playerID}")
    @Schema
    Player getPlayer(@RequestParam("playerID") String playerId) {
        return new Player();
    }
}
