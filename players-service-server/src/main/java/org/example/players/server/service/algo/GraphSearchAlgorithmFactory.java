package org.example.players.server.service.algo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GraphSearchAlgorithmFactory {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Value("${algo.graph-search-algorithm}")
    private String algorithm;

    public GraphSearchAlgorithm getGraphSearchAlgorithm() throws Exception {
        _logger.trace("Using [{}] Graph Search Algorithm.", algorithm);
        switch (algorithm) {
            case "BFS":
                return new BFSAlgorithm();
            default:
                throw new Exception(String.format("Unsupported Graph Search Algorithm [%s]", algorithm));
        }
    }
}
