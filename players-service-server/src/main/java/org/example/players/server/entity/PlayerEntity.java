package org.example.players.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Iterator;

@Entity
public class PlayerEntity implements Comparable<PlayerEntity> {
    @Id
    private String playerID;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private String deathYear;
    private String deathMonth;
    private String deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private String weight;
    private String height;
    private String bats;
    private String throwz;
    private String debut;
    private String finalGame;
    private String retroID;
    private String bbrefID;

    public PlayerEntity() {}

    public PlayerEntity(String playerID) {
        this.playerID = playerID;
    }

    public static PlayerEntity fromList(Iterable<String> attributes) {
        if (attributes == null) {
            throw new RuntimeException("Attributes array can't be null. Must have at least one element for PlayerID.");
        }
        Iterator<String> iterator = attributes.iterator();
        if (!iterator.hasNext()) {
            throw new RuntimeException("Attributes array can't be empty. Must have at least one element for PlayerID.");
        }
        PlayerEntity entity = new PlayerEntity(iterator.next());
        entity.setBirthYear(iterator.next());
        entity.setBirthMonth(iterator.next());
        entity.setBirthDay(iterator.next());
        entity.setBirthCountry(iterator.next());
        entity.setBirthState(iterator.next());
        entity.setBirthCity(iterator.next());
        entity.setDeathYear(iterator.next());
        entity.setDeathMonth(iterator.next());
        entity.setDeathDay(iterator.next());
        entity.setDeathCountry(iterator.next());
        entity.setDeathState(iterator.next());
        entity.setDeathCity(iterator.next());
        entity.setNameFirst(iterator.next());
        entity.setNameLast(iterator.next());
        entity.setNameGiven(iterator.next());
        entity.setWeight(iterator.next());
        entity.setHeight(iterator.next());
        entity.setBats(iterator.next());
        entity.setThrowz(iterator.next());
        entity.setDebut(iterator.next());
        entity.setFinalGame(iterator.next());
        entity.setRetroID(iterator.next());
        entity.setBbrefID(iterator.next());
        return entity;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public PlayerEntity withPlayerID(String playerID) {
        setPlayerID(playerID);
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public String getThrowz() {
        return throwz;
    }

    public void setThrowz(String throwz) {
        this.throwz = throwz;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    @Override
    public int compareTo(PlayerEntity other) {
        return this.playerID.compareTo(other.playerID);
    }
}