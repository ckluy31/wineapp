package com.example.winestats.breakdown;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class WineService {

    public Wine readJsonFile(String lotCode) {
        Wine wineObj;
        wineObj = new Wine();
        List<Map.Entry<String, Double>> orderedCompList = null;
        // retrieve data from json
        JSONParser parser = new JSONParser();
        try {
            String fileLocation = "./data/" + lotCode + ".json";
            JSONObject data = (JSONObject) parser.parse(new FileReader(fileLocation));
            String json = data.toJSONString();
            System.out.println(json);

            Double volume = (Double) data.get("volume");
            System.out.println("Volume:" + volume);

            String description = (String) data.get("description");
            System.out.println("Des:" + description);

            String tankCode = (String) data.get("tankCode");

            String productState = (String) data.get("productState");

            String ownerName = (String) data.get("ownerName");

            List<BreakdownComponent> listComponents = new ArrayList<BreakdownComponent>();


            JSONArray componentsList = (JSONArray) data.get("components");


            wineObj = new Wine(lotCode, volume, description, tankCode, productState, ownerName, componentsList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return wineObj;
    }
}
