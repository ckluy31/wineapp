//package com.example.winestats.breakdown;
//
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class BreakdownService {
//
//    public String getBreakdownByVariety(String lotCode) {
//        HashMap<String, Double> breakdown= new Variety(lotCode).getBreakdown();
//        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(breakdown.entrySet());
//        list.sort(new Comparator<Map.Entry<String, Double>>() {
//            @Override
//            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
//                // comparator will sort by descending order of percentage
//                return o2.getValue().compareTo(o1.getValue());
//
//            }
//        });
//        return list.toString();
//    }
//}
