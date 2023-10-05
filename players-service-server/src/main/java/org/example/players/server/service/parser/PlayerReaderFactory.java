package org.example.players.server.service.parser;

public class PlayerReaderFactory {
    public PlayerReader create(String format) {
        return switch (format.toUpperCase()) {
            case "CSV" -> new CsvPlayerReader();
            default -> throw new IllegalStateException("Unexpected value: " + format.toUpperCase());
        };
    }
}
