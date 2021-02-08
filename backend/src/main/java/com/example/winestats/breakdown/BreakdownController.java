package com.example.winestats.breakdown;

import com.example.winestats.wine.Wine;
import com.example.winestats.wine.WineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JSONObject getBreakdownByYear(@PathVariable String lotCode) throws JsonProcessingException, ParseException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "year");
        String bdString = new ObjectMapper().writeValueAsString(bd);
        return wineService.convertStringtoJSONObject(bdString);
    }

    @RequestMapping(path = "/api/breakdown/variety/{lotCode}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JSONObject getBreakdownByVariety(@PathVariable String lotCode) throws JsonProcessingException, ParseException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "variety");
        String bdString = new ObjectMapper().writeValueAsString(bd);
        return wineService.convertStringtoJSONObject(bdString);
    }

    @RequestMapping(path = "/api/breakdown/region/{lotCode}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JSONObject getBreakdownByRegion(@PathVariable String lotCode) throws JsonProcessingException, ParseException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "region");
        String bdString = new ObjectMapper().writeValueAsString(bd);
        return wineService.convertStringtoJSONObject(bdString);
    }
    @RequestMapping(path = "/api/breakdown/year-variety/{lotCode}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JSONObject getBreakdownByYearVariety(@PathVariable String lotCode) throws JsonProcessingException, ParseException {
        Wine wineObj = wineService.readJsonFile(lotCode);
        Breakdown bd = breakdownService.getBreakdownByType(wineObj, "year-variety");
        String bdString = new ObjectMapper().writeValueAsString(bd);
        return wineService.convertStringtoJSONObject(bdString);
    }
}
