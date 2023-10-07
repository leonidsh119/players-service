package org.example.players.sdk;

import org.example.players.model.FindUnreachableNodesRequest;

public interface IPlayersSdk {
    String findUnreachableNodes(FindUnreachableNodesRequest request);
    boolean healthCheck();
}
