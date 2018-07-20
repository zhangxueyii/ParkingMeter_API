package com.example.parkingmeter;

import com.example.parkingmeter.model.EndParkingResponse;
import com.example.parkingmeter.model.ParkingInfo;
import com.example.parkingmeter.model.StartParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
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
}