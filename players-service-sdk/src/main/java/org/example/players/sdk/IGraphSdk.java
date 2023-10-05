package org.example.players.sdk;

public interface IGraphSdk {
    String findUnreachableNodes(FindUnreachableNodesRequest request);
    boolean healthCheck();
}
