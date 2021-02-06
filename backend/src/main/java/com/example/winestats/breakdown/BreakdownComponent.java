package com.example.winestats.breakdown;


import com.fasterxml.jackson.databind.ObjectMapper;

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


}