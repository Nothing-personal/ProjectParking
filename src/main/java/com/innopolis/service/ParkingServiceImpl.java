package com.innopolis.service;

import com.innopolis.entity.Parking;
import com.innopolis.repository.ParkingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
@Service("parkingService")
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    @Qualifier("parkingRepository")
    private ParkingRepositoryImpl parkingRepository = new ParkingRepositoryImpl();

    @Override
    public boolean addParking(String coordinates, int capacity, String parkingName) {
        try {
            parkingRepository.addParking(new Parking(coordinates, capacity, parkingName));
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
