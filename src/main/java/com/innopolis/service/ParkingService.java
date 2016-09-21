package com.innopolis.service;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
public interface ParkingService {

    boolean addParking(String coordinates, int capacity, String parkingName);
}
