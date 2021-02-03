package com.example.winestats.breakdown;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VarietyService {
    public String getBreakdownByVariety(String lotCode) {
        HashMap<String, Double> breakdown= new Variety(lotCode).getBreakdown();
        return breakdown.toString();
    }
}
