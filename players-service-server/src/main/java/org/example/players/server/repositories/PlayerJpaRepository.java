package org.example.players.server.repositories;

import org.example.players.server.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, String> {
}
