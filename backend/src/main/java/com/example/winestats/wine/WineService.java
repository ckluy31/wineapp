package com.example.winestats.wine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WineService {

    public JSONObject convertStringtoJSONObject (String str) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(str);
    }

    public JSONArray convertStringtoJSONArray (String str) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(str);
    }

    public List<Wine> readAllWine() {
        List<Wine> allWines = new ArrayList<Wine>();
        try {
            File[] files = new File("./backend/src/main/resources/data/").listFiles();
            assert files != null;
            for (File file: files) {
                String lotCode = file.getName().replace(".json", "");
                allWines.add(readJsonFile(lotCode));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return allWines;
    }

    public List<Wine> searchWine(String searchQuery) {
        List<Wine> allWines = readAllWine();
        List<Wine> matchedWines = new ArrayList<Wine>();
        // make search query case insensitive
        searchQuery = searchQuery.toLowerCase();
        for(Wine wine:allWines) {
            // Assume that lot code is never null as it is a unique identifier
            String wineLotCode = wine.getLotCode();
            String wineDescription = wine.getDescription();
            if (wineDescription != null) {
                // make description case insensitive
                wineDescription = wineDescription.toLowerCase();
            }
            // add as matched list if the search query is a substring of either its lotcode or description
            if (wineLotCode.contains(searchQuery) || (wineDescription != null && wineDescription.contains(searchQuery))) {
                matchedWines.add(wine);
            }
        }

        return matchedWines;
    }

    public Wine readJsonFile(String lotCode) {
        Wine wineObj;
        wineObj = new Wine();
        // retrieve data from json
        JSONParser parser = new JSONParser();
        try {
            String fileLocation = "./backend/src/main/resources/data/" + lotCode + ".json";
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
