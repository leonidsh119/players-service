package org.example.players.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

import java.util.Iterator;
import java.util.Objects;

public class Player extends RepresentationModel<Player> {
    @NotBlank
    private String playerID;

    @Min(1900)
    @Max(2099)
    private String birthYear;

    @Min(1)
    @Max(12)
    private String birthMonth;

    @Min(1)
    @Max(31)
    private String birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;

    @Min(1900)
    @Max(2099)
    private String deathYear;

    @Min(1)
    @Max(21)
    private String deathMonth;

    @Min(1)
    @Max(31)
    private String deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;

    @Min(40)
    @Max(200)
    private String weight;

    @Min(140)
    @Max(300)
    private String height;
    private String bats;
    private String throwz;
    private String debut;
    private String finalGame;
    private String retroID;
    private String bbrefID;

    public static Player fromList(Iterable<String> attributes) {
        Iterator<String> iterator = attributes.iterator();
        return new Player(iterator.next())
                .withBirthYear(iterator.next())
                .withBirthMonth(iterator.next())
                .withBirthDay(iterator.next())
                .withBirthCountry(iterator.next())
                .withBirthState(iterator.next())
                .withBirthCity(iterator.next())
                .withDeathYear(iterator.next())
                .withDeathMonth(iterator.next())
                .withDeathDay(iterator.next())
                .withDeathCountry(iterator.next())
                .withDeathState(iterator.next())
                .withDeathCity(iterator.next())
                .withNameFirst(iterator.next())
                .withNameLast(iterator.next())
                .withNameGiven(iterator.next())
                .withWeight(iterator.next())
                .withHeight(iterator.next())
                .withBats(iterator.next())
                .withThrowz(iterator.next())
                .withDebut(iterator.next())
                .withFinalGame(iterator.next())
                .withRetroID(iterator.next())
                .withBbrefID(iterator.next());
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(playerID, player.playerID)
                && Objects.equals(birthYear, player.birthYear)
                && Objects.equals(birthMonth, player.birthMonth)
                && Objects.equals(birthDay, player.birthDay)
                && Objects.equals(birthCountry, player.birthCountry)
                && Objects.equals(birthState, player.birthState)
                && Objects.equals(birthCity, player.birthCity)
                && Objects.equals(deathYear, player.deathYear)
                && Objects.equals(deathMonth, player.deathMonth)
                && Objects.equals(deathDay, player.deathDay)
                && Objects.equals(deathCountry, player.deathCountry)
                && Objects.equals(deathState, player.deathState)
                && Objects.equals(deathCity, player.deathCity)
                && Objects.equals(nameFirst, player.nameFirst)
                && Objects.equals(nameLast, player.nameLast)
                && Objects.equals(nameGiven, player.nameGiven)
                && Objects.equals(weight, player.weight)
                && Objects.equals(height, player.height)
                && Objects.equals(bats, player.bats)
                && Objects.equals(throwz, player.throwz)
                && Objects.equals(debut, player.debut)
                && Objects.equals(finalGame, player.finalGame)
                && Objects.equals(retroID, player.retroID)
                && Objects.equals(bbrefID, player.bbrefID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playerID, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay, deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, bats, throwz, debut, finalGame, retroID, bbrefID);
    }
}