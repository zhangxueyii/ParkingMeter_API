package com.example.parkingmeter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "Hello Java!";
    }

    @RequestMapping("/beginPark")
    public String beginPark(String timeStamp) {
        return "Begin Parking at " + timeStamp;
    }

    @RequestMapping("/endPark")
    public String endPark(String recordId, String timeStamp) {
        return "End Parking at " + timeStamp;
    }
}