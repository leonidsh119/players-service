package com.mend.graph.server.model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Graph {
    private final String graphId;
    private final Dictionary<String, Node> nodes = new Hashtable<>();

    public Graph(String id) {
        graphId = id;
    }

    public String getGraphId() {
        return graphId;
    }

    public void addNode(Node node) {
        if(node != null) {
            nodes.put(node.getId(), node);
        }
    }

    public void addNode(String nodeId) {
        if(nodeId != null && !nodeId.isBlank() && !nodeId.isEmpty()) {
            addNode(new Node(nodeId));
        }
    }

    public Node findNode(String nodeId) {
        return nodes.get(nodeId);
    }

    public void addNodeNeighbour(String nodeId, String neighbourId) {
        findNode(nodeId).addNeighbour(findNode((neighbourId)));
    }

    public void unvisit() {
        nodes.elements().asIterator().forEachRemaining(node -> node.setVisited(false));
    }

    public Iterable<Node> getVisitedNodes() {
        List<Node> visited = new ArrayList<>();
        nodes.elements().asIterator().forEachRemaining(node -> {
            if(node.isVisited()) {
                visited.add(node);
            }
        });
        return visited;
    }

    public Iterable<Node> getNotVisitedNodes() {
        List<Node> visited = new ArrayList<>();
        nodes.elements().asIterator().forEachRemaining(node -> {
            if(!node.isVisited()) {
                visited.add(node);
            }
        });
        return visited;
    }
}
