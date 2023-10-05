package com.mend.graph.server.service;

import com.mend.graph.server.model.Graph;
import com.mend.graph.server.model.Node;
import com.mend.graph.server.service.algo.GraphSearchAlgorithm;
import com.mend.graph.server.service.algo.GraphSearchAlgorithmFactory;
import com.mend.graph.server.service.parser.GraphParser;
import com.mend.graph.server.service.parser.GraphParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GraphService {
    private final Logger _logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GraphParserFactory graphParserFactory;

    @Autowired
    private GraphSearchAlgorithmFactory graphSearchAlgorithmFactory;

    private GraphSearchAlgorithm graphSearchAlgorithm;

    @PostConstruct
    public void initializeAlgorithm() throws Exception {
        graphSearchAlgorithm = graphSearchAlgorithmFactory.getGraphSearchAlgorithm();
    }

    public Iterable<String> findUnreachableNodes(String entryNode, String graph) throws Exception {
        _logger.trace("Searching for unreachable nodes in graph [{}] from node [{}]", graph, entryNode);
        GraphParser graphParser = graphParserFactory.getGraphParser(graph);
        Graph graphModel = graphParser.parse(graph);

        graphSearchAlgorithm.search(graphModel, entryNode);

        return StreamSupport.stream(graphModel.getNotVisitedNodes().spliterator(), false)
                .map(Node::getId)
                .collect(Collectors.toList());
    }
}
