package com.example.warcraft3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Hero {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "race")
    private Race race;

    @Enumerated(EnumType.STRING)
    @Column(name = "primary_attribute")
    private PrimaryAttribute primaryAttribute;

    @Column(name = "description")
    private String description;

    @Column(name = "movement_speed")
    private Integer movementSpeed;

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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public PrimaryAttribute getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(PrimaryAttribute primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Integer movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

}