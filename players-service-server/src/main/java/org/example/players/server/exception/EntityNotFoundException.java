package org.example.players.server.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String entityName, String entityId) {
        super("404", String.format("%s with ID %s not found.", entityName, entityId));
    }

    @Override
    public HttpStatus getHttpStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
