package com.example.winestats.breakdown;

import com.example.winestats.wine.Wine;
import com.example.winestats.wine.WineService;
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
    public String getBreakdownByYear(@PathVariable String lotCode) {
        Wine wineObj = wineService.readJsonFile(lotCode);
        return breakdownService.getBreakdownByType(wineObj, "year").toString();
    }

    @RequestMapping(path = "/api/breakdown/variety/{lotCode}")
    public String getBreakdownByVariety(@PathVariable String lotCode) {
        Wine wineObj = wineService.readJsonFile(lotCode);
        return breakdownService.getBreakdownByType(wineObj, "variety").toString();
    }

    @RequestMapping(path = "/api/breakdown/region/{lotCode}")
    public String getBreakdownByRegion(@PathVariable String lotCode) {
        Wine wineObj = wineService.readJsonFile(lotCode);
        return breakdownService.getBreakdownByType(wineObj, "region").toString();
    }
//    @RequestMapping(path = "/api/breakdown/year-variety/{lotCode}")
//    public String getBreakdownByYearVariety(@PathVariable String lotCode) {
//        Wine wineObj = wineService.readJsonFile(lotCode);
//        return breakdownService.getBreakdownByType(wineObj, "year-variety").toString();
//    }

    @RequestMapping(path = "/api/test/{lotCode}")
    public Object populate(@PathVariable String lotCode) {
        System.out.println(lotCode);
        return wineService.readJsonFile(lotCode);
    }
}
