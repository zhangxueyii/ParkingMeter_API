package com.example.parkingmeter;

import com.example.parkingmeter.dao.ParkingDao;
import com.example.parkingmeter.model.ParkingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service(value = "parkingService")
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;


    @Override
    public int addParkingInfo(ParkingInfo parkingInfo) {
        return parkingDao.insert(parkingInfo);
    }

    @Override
    public int updateEndParking( String uniqueId, Timestamp timeStamp) {
        return parkingDao.updateEndTime(uniqueId, timeStamp);
    }

    @Override
    public ParkingInfo getLastParking() {
        return parkingDao.selectLastParkingInfo();
    }
}
