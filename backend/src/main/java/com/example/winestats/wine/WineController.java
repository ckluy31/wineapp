package com.example.winestats.wine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WineController {
    private final WineService wineService;

    @Autowired
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @RequestMapping(path = "/api/wine/search/{searchQuery}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JSONArray getWineBySearchQuery(@PathVariable String searchQuery) throws JsonProcessingException, ParseException {
            List<Wine> matchedWine = wineService.searchWine(searchQuery);
            String wineString = new ObjectMapper().writeValueAsString(matchedWine);
            return wineService.convertStringtoJSONArray(wineString);
    }


}
