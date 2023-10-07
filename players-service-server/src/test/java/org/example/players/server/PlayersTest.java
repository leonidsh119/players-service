package org.example.players.server;

import org.example.players.model.Player;
import org.example.players.sdk.PlayersSdk;
import org.example.players.sdk.IPlayersSdk;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.util.Arrays;
import java.util.regex.Pattern;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayersTest {
    private final Pattern _pattern = Pattern.compile(",");

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
    public void getPlayerByIdTest() {
        String csvLine = "reedeic01,1858,,,USA,OH,Cincinnati,1913,1,15,USA,OH,Cincinnati,Icicle,Reeder,Julius Edward,195,73,R,,1884-06-24,1884-08-05,reedi101,reedeic01";
        Iterable<String> attributes = Arrays.stream(_pattern.split(csvLine)).toList();
        Player testPlayer = Player.fromList(attributes);
        Player player = _sdk.getPlayerById(testPlayer.getPlayerID());
        assert testPlayer.equals(player);
    }

    @Test
    public void getNotPlayerByIdTest() {
        Player player = _sdk.getPlayerById("NOT-ID");
        assert player == null;
    }

//    @Test()
    public void getPlayersPageableTest() {
        Pageable pageable = PageRequest.of(0, 20);
        PagedModel<Player> players = _sdk.getPlayersPageable(pageable);
        assert players != null;
    }
}
