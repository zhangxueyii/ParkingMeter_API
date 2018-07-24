package com.example.parkingmeter;

import com.example.parkingmeter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
public class MainController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping("/")
    public String index() {
        return "Hello Java!";
    }

    @RequestMapping("/beginPark")
    public StartParkingResponse beginPark(String timeStamp) {
        StartParkingResponse response = new StartParkingResponse();

        String uniqueId = UUID.randomUUID().toString();
        ParkingInfo parkingInfo = new ParkingInfo();
        parkingInfo.setUnique_id(uniqueId);
        parkingInfo.setBeginTime(Timestamp.valueOf(timeStamp));
        parkingInfo.setDel(false);

        int retCode = parkingService.addParkingInfo(parkingInfo);

        if (retCode == 1) {
            response.setSuccessful(true);
            response.setUniqueId(uniqueId);
        }

        return response;
    }

    @RequestMapping("/endPark")
    public EndParkingResponse endPark(String uniqueId, String timeStamp) {
        EndParkingResponse response = new EndParkingResponse();
        response.setSuccessful(false);

        if (parkingService.updateEndParking(uniqueId, Timestamp.valueOf(timeStamp)) == 1) {
            response.setSuccessful(true);
        }

        return response;
    }

    @RequestMapping("/getLastParking")
    public LastParkingInfoResponse getLastParking() {
        LastParkingInfoResponse response = new LastParkingInfoResponse();
        response.setSuccessful(false);

        ParkingInfo parkingInfo = parkingService.getLastParking();
        if (parkingInfo != null) {
            response.setSuccessful(true);
            response.setUnique_id(parkingInfo.getUnique_id());
            response.setBeginTime(parkingInfo.getBeginTime().toInstant());
            response.setEndTime(parkingInfo.getEndTime().toInstant());
            response.setIsDel(parkingInfo.getDel());
        }

        return response;
    }
}