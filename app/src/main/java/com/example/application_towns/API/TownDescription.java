package com.example.application_towns.API;

public class TownDescription {

    private long Population;
    private String Country;
    private String Name;
    private String language;

    public long getPopulation() {
        return Population;
    }

    public void setPopulation(long population) {
        this.Population = population;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
