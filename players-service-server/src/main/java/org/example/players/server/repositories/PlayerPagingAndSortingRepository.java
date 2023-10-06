package org.example.players.server.repositories;

import org.example.players.server.entity.PlayerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerPagingAndSortingRepository extends PagingAndSortingRepository<PlayerEntity, String> {
}
