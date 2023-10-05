package org.example.players.server.controller;

import org.example.players.sdk.FindUnreachableNodesRequest;
import org.example.players.server.service.GraphService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/algo")
public class AlgoController extends BaseController {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GraphService _service;

    @PostMapping
    @Schema
    String findUnreachableEdges(@RequestBody FindUnreachableNodesRequest request) throws Exception {
        _logger.trace("Searching for unreachable nodes in graph [{}] from node [{}]", request.getGraph(), request.getE1());
        Iterable<String> unreachableNodes = _service.findUnreachableNodes(request.getE1(), request.getGraph());
        return String.format("{%s}", String.join(",", unreachableNodes));
    }
}
