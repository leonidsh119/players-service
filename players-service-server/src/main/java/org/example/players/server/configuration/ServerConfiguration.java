package org.example.players.server.configuration;

import org.example.players.server.data.PlayerMap;
import org.example.players.server.repositories.MapPlayerDAO;
import org.example.players.server.repositories.PlayerDAO;
import org.example.players.server.service.parser.PlayerReaderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {
    @Value("${player.storage-type}")
    private String storageType;

    @Bean
    public PlayerReaderFactory getPlayerReaderFactory() {
        return new PlayerReaderFactory();
    }

    @Bean
    public PlayerDAO getPlayerDAO() {
        return switch (storageType.toUpperCase()) {
            case "MAP" -> new MapPlayerDAO();
            case "MONGODB" -> throw new RuntimeException("Unsupported MONGODB Player Storage Type.");
            default -> throw new RuntimeException(String.format("Unsupported Player Storage Type [%s].", storageType));
        };
    }

    @Bean
    public PlayerMap getPlayerMap() {
        if(storageType.equalsIgnoreCase("MAP")) {
            return new PlayerMap();
        } else {
            return null;
        }
    }
}
