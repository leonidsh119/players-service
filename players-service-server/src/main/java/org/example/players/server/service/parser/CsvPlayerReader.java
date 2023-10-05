package org.example.players.server.service.parser;

import org.example.players.server.model.PlayerEntity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

public class CsvPlayerReader implements PlayerReader {
    private final Pattern _pattern = Pattern.compile(",");
    @Override
    public List<PlayerEntity> readAllPlayers(InputStream csvInputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvInputStream, StandardCharsets.UTF_8))) {
            return reader
                    .lines()
                    .skip(1) // header
                    .map(this::toPlayer)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PlayerEntity toPlayer(String line) {
        String[] attributes = _pattern.split(line);
        return new PlayerEntity(attributes);
    }
}
