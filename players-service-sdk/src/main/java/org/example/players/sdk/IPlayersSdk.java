package org.example.players.sdk;

import org.example.players.model.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface IPlayersSdk extends IBaseSdk {
    Player getPlayerById(String playerId);
    PagedModel<Player> getPlayersPageable(Pageable pageable);
}
