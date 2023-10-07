package org.example.players.model;

import org.springframework.hateoas.RepresentationModel;

public class Player extends RepresentationModel<Player> {
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

    public Player() {

    }

    public Player(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Player withPlayerID(String playerID) {
        setPlayerID(playerID);
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public Player withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Player withBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
        return this;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Player withBirthDay(String birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Player withBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
        return this;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public Player withBirthState(String birthState) {
        this.birthState = birthState;
        return this;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Player withBirthCity(String birthCity) {
        this.birthCity = birthCity;
        return this;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public Player withDeathYear(String deathYear) {
        this.deathYear = deathYear;
        return this;
    }

    public String getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Player withDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
        return this;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public Player withDeathDay(String deathDay) {
        this.deathDay = deathDay;
        return this;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public Player withDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
        return this;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public Player withDeathState(String deathState) {
        this.deathState = deathState;
        return this;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public Player withDeathCity(String deathCity) {
        this.deathCity = deathCity;
        return this;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public Player withNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
        return this;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public Player withNameLast(String nameLast) {
        this.nameLast = nameLast;
        return this;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public Player withNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Player withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Player withHeight(String height) {
        this.height = height;
        return this;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public Player withBats(String bats) {
        this.bats = bats;
        return this;
    }

    public String getThrowz() {
        return throwz;
    }

    public void setThrowz(String throwz) {
        this.throwz = throwz;
    }

    public Player withThrowz(String throwz) {
        this.throwz = throwz;
        return this;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public Player withDebut(String debut) {
        this.debut = debut;
        return this;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }

    public Player withFinalGame(String finalGame) {
        this.finalGame = finalGame;
        return this;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public Player withRetroID(String retroID) {
        this.retroID = retroID;
        return this;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    public Player withBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
        return this;
    }
}