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

            for (Object o:componentsList) {
                JSONObject element = (JSONObject) o;

                // find the relevant variety and percentage values
                String variety = (String) element.get("variety");
                System.out.println(variety);

                Double percentage = (Double) element.get("percentage");
                System.out.println(percentage);

                BreakdownComponent component = new BreakdownComponent(variety, percentage);
                listComponents.add(component);

//                //add to cumulative total if variety key exists already, otherwise create new entry
//                if (mappedComponents.containsKey(variety)) {
//                    mappedComponents.put(variety, mappedComponents.get(variety) + percentage);
//                } else {
//                    mappedComponents.put(variety, percentage);
//                }
//                System.out.println(mappedComponents.entrySet());
//
//                // sort the list to be ordered by highest percentage value first
//                orderedCompList = new LinkedList<Map.Entry<String, Double>>(mappedComponents.entrySet());
//                orderedCompList.sort(new Comparator<Map.Entry<String, Double>>() {
//                    @Override
//                    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
//                        // comparator will sort by descending order of percentage
//                        return o2.getValue().compareTo(o1.getValue());
//
//                    }
//                });
//                System.out.println(orderedCompList);


            }

            wineObj = new Wine(lotCode, volume, description, tankCode, productState, ownerName, listComponents);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return wineObj;
    }
}
