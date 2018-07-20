package com.example.parkingmeter.dao;

import com.example.parkingmeter.model.ParkingInfo;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Component
public interface ParkingDao {

    int insert(ParkingInfo parkingInfo);

    int updateEndTime(String uniqueId, Timestamp endTime);

    List<ParkingInfo> selectRecentParkingInfo();
}
