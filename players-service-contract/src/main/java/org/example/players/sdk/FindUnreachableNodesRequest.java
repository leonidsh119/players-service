package org.example.players.sdk;

import io.swagger.v3.oas.annotations.media.Schema;

public class FindUnreachableNodesRequest {
    @Schema(example = "1", description = "Entry node")
    private String e1;
    @Schema(example = "digraph graphname{\n0->1\n0->2\n2->1\n3->4}", description = "Graph representation in DOT format")
    private String graph;

    public FindUnreachableNodesRequest() {

    }

    public String getE1() {
        return e1;
    }

    public void setE1(String e1) {
        this.e1 = e1;
    }

    public FindUnreachableNodesRequest withE1(String e1) {
        setE1(e1);
        return this;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public FindUnreachableNodesRequest withGraph(String graph) {
        setGraph(graph);
        return this;
    }
}
