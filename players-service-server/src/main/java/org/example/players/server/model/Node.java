package org.example.players.server.model;

import java.util.ArrayList;

public class Node {
    private final String id;

    private final ArrayList<Node> neighbours;

    private boolean isVisited;

    public Node(String id) {
        this.id = id;
        neighbours = new ArrayList<>();
        this.isVisited = false;
    }

    public String getId() {
        return id;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void addNeighbour(Node neighbour) {
        if(neighbour == null) {
            return;
        }
        if(getId().equals(neighbour.getId())) { // no need to add yourself
            return;
        }
        if(neighbours.stream().anyMatch(node -> node.getId().equals(neighbour.getId()))) { // not needed to add multiple nodes with the same Id
            return;
        }
        this.neighbours.add(neighbour);
    }

    public void addNeighbours(Iterable<Node> neighbours) {
        if(neighbours != null) {
            neighbours.forEach(this::addNeighbour);
        }
    }

    public Iterable<Node> getNeighbours() {
        return neighbours;
    }
}
