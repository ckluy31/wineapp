package com.example.winestats.wine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class WineService {

    public Wine readJsonFile(String lotCode) {
        Wine wineObj;
        wineObj = new Wine();
        // retrieve data from json
        JSONParser parser = new JSONParser();
        try {
            String fileLocation = "./backend/data/" + lotCode + ".json";
            JSONObject data = (JSONObject) parser.parse(new FileReader(fileLocation));

            Double volume = (Double) data.get("volume");

            String description = (String) data.get("description");

            String tankCode = (String) data.get("tankCode");

            String productState = (String) data.get("productState");

            String ownerName = (String) data.get("ownerName");

            JSONArray componentsList = (JSONArray) data.get("components");


            wineObj = new Wine(lotCode, volume, description, tankCode, productState, ownerName, componentsList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return wineObj;
    }
}
