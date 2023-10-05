package org.example.players.server.service.algo;

import org.example.players.server.model.Graph;
import org.example.players.server.model.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm implements GraphSearchAlgorithm {
    private final Logger _logger = LoggerFactory.getLogger(getClass());
    private final Queue<Node> searchNodes = new LinkedList<>();

    @Override
    public void search(Graph graph, String entryNodeId) {
        _logger.trace("Cleaning all visited nodes");
        graph.unvisit();

        _logger.trace("Finding Entry Node [{}]", entryNodeId);
        Node entryNode = graph.findNode(entryNodeId);
        if(entryNode == null) {
            _logger.trace("Entry Node [{}] not found. Exiting search with no visited nodes.", entryNodeId);
            return;
        } else {
            _logger.trace("Setting Entry Node [{}] as visited.", entryNodeId);
            entryNode.setVisited(true);
        }

        _logger.trace("Initializing SearchNodes Queue with Entry Node [{}]", entryNodeId);
        searchNodes.clear();
        _logger.trace("Adding Entry Node [{}] to SearchNodes queue", entryNodeId);
        searchNodes.add(entryNode);

        while(!searchNodes.isEmpty()) {
            Node next = searchNodes.poll();
            _logger.trace("Polling next node [{}]", next.getId());
            next.getNeighbours().forEach(node -> {
                _logger.trace("Handling Node's [{}] neighbour [{}]", next.getId(), node.getId());
                if(!node.isVisited()) {
                    _logger.trace("Setting Node's [{}] neighbour [{}] as visited", next.getId(), node.getId());
                    node.setVisited(true);
                    _logger.trace("Adding Node's [{}] neighbour [{}] to SearchNodes queue", next.getId(), node.getId());
                    searchNodes.add(node);
                }
            });
        }
        _logger.trace("BFS finished search from Entry Node [{}]", entryNodeId);
    }
}
