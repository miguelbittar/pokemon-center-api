package com.hoenn.pokemoncenter.pokemon_center_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Every Pokemon needs a name!")
    private String name;

    @NotBlank(message = "Every Pokemon belongs to a species!")
    private String species;

    @Min(value = 1, message = "Pokemon must be at least level 1!")
    @Max(value = 100, message = "Level cannot exceed 100!")
    private int level;

    @Enumerated(EnumType.STRING)
    private HealthCondition healthCondition;

    private LocalDateTime entryDate;
    private Long trainerId;

    public Pokemon(){}

    public Pokemon (String name, String species, int level, Long trainerId, HealthCondition healthCondition) {
        this.name = name;
        this.species = species;
        this.level = level;
        this.trainerId = trainerId;
        this.healthCondition = healthCondition;
        this.entryDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HealthCondition getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(HealthCondition healthCondition) {
        this.healthCondition = healthCondition;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString(){
        return "Pokemon{ name: " + name + " , species: " + species + " }";
    }
}
