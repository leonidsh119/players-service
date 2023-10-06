package org.example.players.server.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.example.players.sdk.Player;
import org.example.players.server.controller.PlayersController;
import org.example.players.server.entity.PlayerEntity;
import org.springframework.hateoas.CollectionModel;
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
        Player albumModel = instantiateModel(entity);

//        albumModel.add(linkTo(
//                methodOn(PlayersController.class)
//                        .getActorById(entity.getPlayerID()))
//                .withSelfRel());

//        albumModel.setId(entity.getId());
//        albumModel.setTitle(entity.getTitle());
//        albumModel.setDescription(entity.getDescription());
//        albumModel.setReleaseDate(entity.getReleaseDate());
//        albumModel.setActors(toActorModel(entity.getActors()));
        return albumModel;
    }

    @Override
    public CollectionModel<Player> toCollectionModel(Iterable<? extends PlayerEntity> entities)
    {
        CollectionModel<Player> models = super.toCollectionModel(entities);

        //models.add(linkTo(methodOn(PlayersController.class).getAllAlbums()).withSelfRel());

        return models;
    }

//    private List<Player> toActorModel(List<PlayerEntity> actors) {
//        if (actors.isEmpty())
//            return Collections.emptyList();
//
//        return actors.stream()
//                .map(actor -> Player.builder()
//                        .id(actor.getId())
//                        .firstName(actor.getFirstName())
//                        .lastName(actor.getLastName())
//                        .build()
//                        .add(linkTo(
//                                methodOn(PlayersController.class)
//                                        .getActorById(actor.getPlayerID()))
//                                .withSelfRel()))
//                .collect(Collectors.toList());
//    }
}
