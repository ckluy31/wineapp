package com.example.winestats.wine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getWineBySearchQuery(@PathVariable String searchQuery) throws JsonProcessingException {
            List<Wine> matchedWine = wineService.searchWine(searchQuery);
            return new ObjectMapper().writeValueAsString(matchedWine);
    }


}
