package com.example.winestats.breakdown;

import com.example.winestats.wine.Wine;
import com.example.winestats.wine.WineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreakdownController {
    private final BreakdownService breakdownService;
    private final WineService wineService;

    @Autowired
    public BreakdownController(BreakdownService breakdownService, WineService wineService) {
        this.breakdownService = breakdownService;
        this.wineService = wineService;
    }

    @RequestMapping(path = "/api/breakdown/year/{lotCode}")
    public String getBreakdownByYear(@PathVariable String lotCode) throws JsonProcessingException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "year");
        return new ObjectMapper().writeValueAsString(bd);
    }

    @RequestMapping(path = "/api/breakdown/variety/{lotCode}")
    public String getBreakdownByVariety(@PathVariable String lotCode) throws JsonProcessingException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "variety");
        return new ObjectMapper().writeValueAsString(bd);
    }

    @RequestMapping(path = "/api/breakdown/region/{lotCode}")
    public String getBreakdownByRegion(@PathVariable String lotCode) throws JsonProcessingException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "region");
        return new ObjectMapper().writeValueAsString(bd);
    }
    @RequestMapping(path = "/api/breakdown/year-variety/{lotCode}")
    public String getBreakdownByYearVariety(@PathVariable String lotCode) throws JsonProcessingException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "year-variety");
        return new ObjectMapper().writeValueAsString(bd);
    }
}
