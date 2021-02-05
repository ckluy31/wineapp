package com.example.winestats.breakdown;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class Breakdown {

    private String breakdownType;
    private List<BreakdownComponent> listComponents;

    public Breakdown(String breakdownType, List<BreakdownComponent> listComponents) {
        this.breakdownType = breakdownType;
        this.listComponents = listComponents;
    }

    public List<BreakdownComponent> getBreakdown() {
        return listComponents;
    }

    public String getBreakdownType() {
        return breakdownType;
    }

}
