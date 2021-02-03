package com.example.winestats.breakdown;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

public class Variety {
    // create a HashMap that stores the percentage breakdowns
    private HashMap<String, Double> breakdownByYear;

    public Variety(String lotCode) {
        // the constructor will construct a hashmap with cumulative percentages by variety type
        this.breakdownByYear = new HashMap<String, Double>();

        // retrieve data from json

        JSONParser parser = new JSONParser();
        try {
            String fileLocation = "./data/" + lotCode + ".json";
            JSONObject data = (JSONObject) parser.parse(new FileReader(fileLocation));
            String json = data.toJSONString();
            System.out.println(json);
            JSONArray componentsList = (JSONArray) data.get("components");

            for (Object o:componentsList) {
                JSONObject component = (JSONObject) o;

                // find the relevant variety and percentage values
                String variety = (String) component.get("variety");
                System.out.println(variety);

                Double percentage = (Double) component.get("percentage");
                System.out.println(percentage);

                // add to cumulative total if variety key exists already, otherwise create new entry
                if (breakdownByYear.containsKey(variety)) {
                    breakdownByYear.put(variety, breakdownByYear.get(variety) + percentage);
                } else {
                    breakdownByYear.put(variety, percentage);
                }

                System.out.println(breakdownByYear);

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // calculate cumulative percentage by variety type


    }

    public HashMap<String, Double> getBreakdown() {

        // return the cumulative percentage for variety
        return breakdownByYear;
    }
}
