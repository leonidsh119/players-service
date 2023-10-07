package org.example.players.server;

import org.example.players.model.FindUnreachableNodesRequest;
import org.example.players.sdk.PlayersSdk;
import org.example.players.sdk.IPlayersSdk;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import jakarta.annotation.PostConstruct;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphAlgoTest {
    @LocalServerPort
    private int _randomServerPort;
    private IPlayersSdk _sdk;

    @PostConstruct
    private void initSdk() {
        _sdk = new PlayersSdk("localhost", _randomServerPort);
    }

    @Test
    public void healthCheckTest() {
        assert _sdk.healthCheck();
    }

    @Test
    public void digraphTest() {
        FindUnreachableNodesRequest request = new FindUnreachableNodesRequest()
                .withE1("1")
                .withGraph("digraph graphname{\n0->1\n0->2\n2->1\n3->4}");

        String unreachableNodes = _sdk.findUnreachableNodes(request);
        assert unreachableNodes != null;

        String[] unreachableNodeIds = unreachableNodes.split(",");
        assert unreachableNodeIds.length == 2;
    }
}
