package com.example.warcraft3.entity;

public class SearchCriteria {
    private String searchTerm;
    private Race searchRace;
    private PrimaryAttribute searchPrimaryAttribute;
    private Integer movementSpeed;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Race getSearchRace() {
        return searchRace;
    }

    public void setSearchRace(Race searchRace) {
        this.searchRace = searchRace;
    }

    public PrimaryAttribute getSearchPrimaryAttribute() {
        return searchPrimaryAttribute;
    }

    public void setSearchPrimaryAttribute(PrimaryAttribute searchPrimaryAttribute) {
        this.searchPrimaryAttribute = searchPrimaryAttribute;
    }

    public Integer getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Integer movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
