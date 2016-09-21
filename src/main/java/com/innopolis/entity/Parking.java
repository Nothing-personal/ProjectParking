package com.innopolis.entity;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */
public class Parking implements DomainObject {

    private int id;
    private String coordinates;
    private int capacity;
    private String parkingName;

    public Parking(String coordinates, int capacity, String parkingName) {
        this.coordinates = coordinates;
        this.capacity = capacity;
        this.parkingName = parkingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }
}
