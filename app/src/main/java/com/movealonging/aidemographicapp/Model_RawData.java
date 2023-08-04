package com.movealonging.aidemographicapp;

public class Model_RawData {
    private int id;
    private String name;
    private String populationDate;
    private String percentage;

    public Model_RawData(int id, String name, String populationDate, String percentage) {
        this.id = id;
        this.name = name;
        this.populationDate = populationDate;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulationDate() {
        return populationDate;
    }

    public void setPopulationDate(String populationDate) {
        this.populationDate = populationDate;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
