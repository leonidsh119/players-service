package com.mend.graph.server.service.parser;

import com.mend.graph.server.model.Graph;
import com.paypal.digraph.parser.GraphEdge;
import com.paypal.digraph.parser.GraphNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class DigraphParser implements GraphParser {
    private final Logger _logger = LoggerFactory.getLogger(getClass());
    private final boolean allEdgesBidirectional;

    public DigraphParser(boolean allEdgesBidirectional) {
        this.allEdgesBidirectional = allEdgesBidirectional;
    }

    @Override
    public Graph parse(String digraph) {
        _logger.trace("parsing graph form DOT string [{}]", digraph);
        InputStream targetStream = new ByteArrayInputStream(digraph.getBytes());
        com.paypal.digraph.parser.GraphParser parser = new com.paypal.digraph.parser.GraphParser(targetStream);
        Map<String, GraphNode> nodes = parser.getNodes();
        Map<String, GraphEdge> edges = parser.getEdges();
        _logger.trace("Parsed Graph [{}] with [{}] Nodes and [{}] Edges", parser.getGraphId(), nodes.size(), edges.size());

        _logger.trace("Building model for graph");
        Graph graph = new Graph(parser.getGraphId());
        nodes.keySet().forEach(graph::addNode);
        edges.values().forEach(edge -> {
            graph.addNodeNeighbour(edge.getNode1().getId(), edge.getNode2().getId());
            if(allEdgesBidirectional) {
                graph.addNodeNeighbour(edge.getNode2().getId(), edge.getNode1().getId());
            }
        });
        _logger.trace("Model created.");
        return graph;
    }
}
