package com.example.winestats.breakdown;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BreakdownService {

    public List<BreakdownComponent> getBreakdownByVariety(Wine wine) {
        JSONArray unsortedBreakdown = wine.getComponentList();
        LinkedHashMap<String, Double> map = new LinkedHashMap<String, Double>();
        for (Object o:unsortedBreakdown) {
            JSONObject element = (JSONObject) o;

            // find the relevant variety and percentage values
            String variety = (String) element.get("variety");
            System.out.println(variety);

            Double percentage = (Double) element.get("percentage");
            System.out.println(percentage);

            //add to cumulative total if variety key exists already, otherwise create new entry
            if (map.containsKey(variety)) {
                map.put(variety, map.get(variety) + percentage);
            } else {
                map.put(variety, percentage);
            }
        }
        System.out.println(map.toString());
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                // comparator will sort by descending order of percentage
                return o2.getValue().compareTo(o1.getValue());

            }
        });
        System.out.println(list.toString());

        List<BreakdownComponent> listComponents = new ArrayList<>();
        for (Map.Entry<String, Double> entry:list) {
            String key = entry.getKey();
            String percentage = entry.getValue().toString();
            listComponents.add(new BreakdownComponent(key, percentage));
        }
        return listComponents;
    }
}
