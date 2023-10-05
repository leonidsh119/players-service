package com.mend.graph.server.service.algo;

import com.mend.graph.server.model.Graph;

public interface GraphSearchAlgorithm {
    void search(Graph graph, String entryNode);
}
