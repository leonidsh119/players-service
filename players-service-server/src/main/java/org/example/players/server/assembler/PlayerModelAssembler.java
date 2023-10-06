package org.example.players.server.assembler;

import org.example.players.sdk.Player;
import org.example.players.server.controller.PlayersController;
import org.example.players.server.entity.PlayerEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class PlayerModelAssembler extends RepresentationModelAssemblerSupport<PlayerEntity, Player> {
    public PlayerModelAssembler() {
        super(PlayersController.class, Player.class);
    }

    @Override
    public Player toModel(PlayerEntity playerEntity) {
        Player playerModel = instantiateModel(playerEntity);

        playerModel.add(linkTo(methodOn(PlayersController.class).getPlayerById(playerEntity.getPlayerID())).withSelfRel());

        playerModel.withBirthYear(playerEntity.getBirthYear())
                .withBirthMonth(playerEntity.getBirthMonth())
                .withBirthDay(playerEntity.getBirthDay())
                .withBirthCountry(playerEntity.getBirthCountry())
                .withBirthState(playerEntity.getBirthState())
                .withBirthCity(playerEntity.getBirthCity())
                .withDeathYear(playerEntity.getDeathYear())
                .withDeathMonth(playerEntity.getDeathMonth())
                .withDeathDay(playerEntity.getDeathDay())
                .withDeathCountry(playerEntity.getDeathCountry())
                .withDeathState(playerEntity.getDeathState())
                .withDeathCity(playerEntity.getDeathCity())
                .withNameFirst(playerEntity.getNameFirst())
                .withNameLast(playerEntity.getNameLast())
                .withNameGiven(playerEntity.getNameGiven())
                .withWeight(playerEntity.getWeight())
                .withHeight(playerEntity.getHeight())
                .withBats(playerEntity.getBats())
                .withThrowz(playerEntity.getThrowz())
                .withDebut(playerEntity.getDebut())
                .withFinalGame(playerEntity.getFinalGame())
                .withRetroID(playerEntity.getRetroID())
                .withBbrefID(playerEntity.getBbrefID());
        return playerModel;
    }

    @Override
    public CollectionModel<Player> toCollectionModel(Iterable<? extends PlayerEntity> entities)
    {
        CollectionModel<Player> actorModels = super.toCollectionModel(entities);
        actorModels.add(linkTo(methodOn(PlayersController.class).getAllPlayers()).withSelfRel());
        return actorModels;
    }
}
