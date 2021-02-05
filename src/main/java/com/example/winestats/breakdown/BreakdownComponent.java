package com.example.winestats.breakdown;


public class BreakdownComponent {
    private final String key;
    private Double percentage;


    public BreakdownComponent(String key, Double percentage) {
        this.key = key;
        this.percentage = percentage;

    }

    public String getKey() {
        return key;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void addPercentage(Double newPercentage) {
        this.percentage += newPercentage;
    }
}
