package com.example.parkingmeter;

import com.example.parkingmeter.model.ParkingInfo;

import java.sql.Timestamp;

public interface ParkingService {
    int addParkingInfo(ParkingInfo parkingInfo);

    int updateEndParking( String uniqueId, Timestamp timeStamp);
}
