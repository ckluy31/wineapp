package com.example.winestats.breakdown;

import com.example.winestats.wine.Wine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BreakdownService {

    public Breakdown getBreakdownByType(Wine wine, String typeBreakdown) {
        JSONArray unsortedBreakdown = wine.getComponentList();
        LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
        for (Object o:unsortedBreakdown) {
            JSONObject element = (JSONObject) o;
            String type;
            Double percentage;

            // find the relevant type and percentage values
            if (typeBreakdown.equals("year-variety")) {
                type = element.get("year").toString() + "-" + element.get("variety").toString();
            } else {

                type = element.get(typeBreakdown).toString();

            }


            percentage = (Double) element.get("percentage");

            //add to cumulative total if variety key exists already, otherwise create new entry
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + percentage);
            } else {
                map.put(type, percentage);
            }
        }
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                // comparator will sort by descending order of percentage
                return o2.getValue().compareTo(o1.getValue());

            }
        });

        List<BreakdownComponent> listComponents = new ArrayList<>();
        for (Map.Entry<String, Double> entry:list) {
            String key = entry.getKey();
            String percentage = entry.getValue().toString();
            listComponents.add(new BreakdownComponent(key, percentage));
        }

        Breakdown breakdown = new Breakdown(typeBreakdown, listComponents);
        return breakdown;
    }
}
