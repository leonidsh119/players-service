package com.mend.graph.sdk;

public interface IGraphSdk {
    String findUnreachableNodes(FindUnreachableNodesRequest request);
    boolean healthCheck();
}
