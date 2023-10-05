package org.example.players.server.service.algo;

import org.example.players.server.model.Graph;

public interface GraphSearchAlgorithm {
    void search(Graph graph, String entryNode);
}
