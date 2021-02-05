package com.example.winestats.breakdown;


import java.util.HashMap;
import java.util.Map;

public class BreakdownComponent {
    private final String key;
    private String percentage;


    public BreakdownComponent(String key, String percentage) {
        this.key = key;
        this.percentage = percentage;

    }

    public String getKey() {
        return key;
    }

    public String getPercentage() {
        return percentage;
    }

    public Map<String, String> getComponent() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("percentage", this.percentage.toString());
        map.put("key", this.key);
        return map;
    }



}
