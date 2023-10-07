package org.example.players.server.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.example.players.model.Player;
import org.example.players.server.controller.PlayersController;
import org.example.players.server.entity.PlayerEntity;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PlayerModelAssembler
        extends RepresentationModelAssemblerSupport<PlayerEntity, Player> {

    public PlayerModelAssembler() {
        super(PlayersController.class, Player.class);
    }

    @Override
    public Player toModel(PlayerEntity entity)
    {
        return instantiateModel(entity)
                .withPlayerID(entity.getPlayerID())
                .withBirthYear(entity.getBirthYear())
                .withBirthMonth(entity.getBirthMonth())
                .withBirthDay(entity.getBirthDay())
                .withBirthCountry(entity.getBirthCountry())
                .withBirthState(entity.getBirthState())
                .withBirthCity(entity.getBirthCity())
                .withDeathYear(entity.getDeathYear())
                .withDeathMonth(entity.getDeathMonth())
                .withDeathDay(entity.getDeathDay())
                .withDeathCountry(entity.getDeathCountry())
                .withDeathState(entity.getDeathState())
                .withDeathCity(entity.getDeathCity())
                .withNameFirst(entity.getNameFirst())
                .withNameLast(entity.getNameLast())
                .withNameGiven(entity.getNameGiven())
                .withWeight(entity.getWeight())
                .withHeight(entity.getHeight())
                .withBats(entity.getBats())
                .withThrowz(entity.getThrowz())
                .withDebut(entity.getDebut())
                .withFinalGame(entity.getFinalGame())
                .withRetroID(entity.getRetroID())
                .withBbrefID(entity.getBbrefID())
                .add(linkTo(
                methodOn(PlayersController.class)
                        .getPlayerById(entity.getPlayerID()))
                .withSelfRel());
    }
}
