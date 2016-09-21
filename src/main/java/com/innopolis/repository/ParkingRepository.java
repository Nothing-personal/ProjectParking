package com.innopolis.repository;


import com.innopolis.entity.DomainObject;

import java.util.Set;

/**
 * Created by Kevin Khanda on 21.09.2016.
 * Interface for Parking repository
 */
interface ParkingRepository<V extends DomainObject>{

    void addParking(V parking);

    Set<String> getParkings();
}
