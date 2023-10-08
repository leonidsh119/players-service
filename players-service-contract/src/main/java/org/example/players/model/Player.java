package org.example.players.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Iterator;
import java.util.Objects;

public class Player extends RepresentationModel<Player> {
    @NotBlank
    @NotNull
    @Schema(example = "reesst01", description = "Player ID")
    private String playerID;

    @Min(1800)
    @Max(2099)
    @Schema(example = "1889", description = "Year of Birth")
    private Integer birthYear;

    @Min(1)
    @Max(12)
    @Schema(example = "2", description = "Month of Birth")
    private Integer birthMonth;

    @Min(1)
    @Max(31)
    @Schema(example = "25", description = "Month of Birth")
    private Integer birthDay;

    @Schema(example = "USA", description = "Country of Birth")
    private String birthCountry;

    @Schema(example = "KY", description = "State of Birth")
    private String birthState;

    @Schema(example = "Cynthiana", description = "City of Birth")
    private String birthCity;

    @Min(1900)
    @Max(2099)
    @Schema(example = "1937", description = "Year of Death")
    private Integer deathYear;

    @Min(1)
    @Max(21)
    @Schema(example = "8", description = "Month of Death")
    private Integer deathMonth;

    @Min(1)
    @Max(31)
    @Schema(example = "29", description = "Day of Death")
    private Integer deathDay;

    @Schema(example = "USA", description = "Country of Death")
    private String deathCountry;

    @Schema(example = "KY", description = "State of Death")
    private String deathState;

    @Schema(example = "Lexington", description = "City of Death")
    private String deathCity;

    @Schema(example = "Stan", description = "First Name")
    private String nameFirst;

    @Schema(example = "Rees", description = "Last Name")
    private String nameLast;

    @Schema(example = "Stanley Milton", description = "Given Name")
    private String nameGiven;

    @Min(40)
    @Max(200)
    @Schema(example = "190", description = "Weight (Pound)")
    private Integer weight;

    @Min(140)
    @Max(300)
    @Schema(example = "75", description = "Height (inch)")
    private Integer height;

    @Schema(example = "L", description = "Bats")
    private String bats;

    @Schema(example = "L", description = "Throws")
    private String throwz;

    @Schema(example = "1918-06-12", description = "Date of Debut")
    private String debut;

    @Schema(example = "1918-07-19", description = "Date of Final Game")
    private String finalGame;

    @Schema(example = "reess101", description = "Old Player ID")
    private String retroID;

    @Schema(example = "reess01", description = "Yet Another Player ID")
    private String bbrefID;

    public static Player fromList(Iterable<String> attributes) {
        Iterator<String> iterator = attributes.iterator();
        return new Player(iterator.next())
                .withBirthYear(valueOfOrNull(iterator.next()))
                .withBirthMonth(valueOfOrNull(iterator.next()))
                .withBirthDay(valueOfOrNull(iterator.next()))
                .withBirthCountry(iterator.next())
                .withBirthState(iterator.next())
                .withBirthCity(iterator.next())
                .withDeathYear(valueOfOrNull(iterator.next()))
                .withDeathMonth(valueOfOrNull(iterator.next()))
                .withDeathDay(valueOfOrNull(iterator.next()))
                .withDeathCountry(iterator.next())
                .withDeathState(iterator.next())
                .withDeathCity(iterator.next())
                .withNameFirst(iterator.next())
                .withNameLast(iterator.next())
                .withNameGiven(iterator.next())
                .withWeight(valueOfOrNull(iterator.next()))
                .withHeight(valueOfOrNull(iterator.next()))
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Player withBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Player withBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
        return this;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Player withBirthDay(Integer birthDay) {
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

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Player withDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
        return this;
    }

    public Integer getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Player withDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
        return this;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }

    public Player withDeathDay(Integer deathDay) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Player withWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Player withHeight(Integer height) {
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

    private static Integer valueOfOrNull(String str) {
        if(str == null || str.isBlank()) {
            return null;
        } else {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }
}