package org.example.players.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.util.Iterator;

@Entity
public class PlayerEntity implements Comparable<PlayerEntity> {
    @Id
    @NotBlank
    @NotNull
    private String playerID;

    @Min(1800)
    @Max(2099)
    private Integer birthYear;

    @Min(1)
    @Max(12)
    private Integer birthMonth;

    @Min(1)
    @Max(31)
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;

    @Min(1800)
    @Max(2099)
    private Integer deathYear;

    @Min(1)
    @Max(12)
    private Integer deathMonth;

    @Min(1)
    @Max(31)
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;

    @Min(0)
    @Max(500)
    private Integer weight;

    @Min(0)
    @Max(150)
    private Integer height;

    @Pattern(regexp = "^([LRBS])$|^$", message = "{ L(eft) | R(ight) | B(oth) | S(witch) | null }")
    private String bats;

    @Pattern(regexp = "^([LRBS])$|^$", message = "{ L(eft) | R(ight) | B(oth) | S(witch) | null }")
    private String throwz;

    @Pattern(regexp = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$|^$", message = "Date in YYYY-MM-DD format or null")
    private String debut;

    @Pattern(regexp = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$|^$", message = "Date in YYYY-MM-DD format or null")
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
        entity.setBirthYear(valueOfOrNull(iterator.next()));
        entity.setBirthMonth(valueOfOrNull(iterator.next()));
        entity.setBirthDay(valueOfOrNull(iterator.next()));
        entity.setBirthCountry(iterator.next());
        entity.setBirthState(iterator.next());
        entity.setBirthCity(iterator.next());
        entity.setDeathYear(valueOfOrNull(iterator.next()));
        entity.setDeathMonth(valueOfOrNull(iterator.next()));
        entity.setDeathDay(valueOfOrNull(iterator.next()));
        entity.setDeathCountry(iterator.next());
        entity.setDeathState(iterator.next());
        entity.setDeathCity(iterator.next());
        entity.setNameFirst(iterator.next());
        entity.setNameLast(iterator.next());
        entity.setNameGiven(iterator.next());
        entity.setWeight(valueOfOrNull(iterator.next()));
        entity.setHeight(valueOfOrNull(iterator.next()));
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
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

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Integer getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
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