package com.example.winestats.breakdown;

import java.util.List;

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
