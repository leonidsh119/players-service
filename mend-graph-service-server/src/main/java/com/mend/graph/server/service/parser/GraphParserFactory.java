package com.mend.graph.server.service.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GraphParserFactory {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Value("${algo.graph-edges-bidirectional}")
    private boolean allEdgesBidirectional;

    public GraphParser getGraphParser(String graph) throws Exception {
        if(graph.startsWith("digraph ")) {
            _logger.trace("Digraph (DOT) format detected.");
            return new DigraphParser(allEdgesBidirectional);
        }
        throw new Exception("Unsupported graph format");
    }
}
