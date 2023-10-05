package org.example.players.server.configuration;

import org.example.players.server.service.parser.PlayerReaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {

    @Bean
    public PlayerReaderFactory getPlayerReaderFactory() {
        return new PlayerReaderFactory();
    }
}
