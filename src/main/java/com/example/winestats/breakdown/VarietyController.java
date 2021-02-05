//package com.example.winestats.breakdown;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//public class VarietyController {
//
//    private final VarietyService varietyService;
//
//    @Autowired
//    public VarietyController(VarietyService varietyService) {
//        this.varietyService = varietyService;
//    }
//
//    @RequestMapping(path = "/api/breakdown/variety/{lotCode}")
//    public String getBreakdownByVariety(@PathVariable String lotCode) {
//        System.out.println(lotCode);
//        return varietyService.getBreakdownByVariety(lotCode);
//    }
//}
