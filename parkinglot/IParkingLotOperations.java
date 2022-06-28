package com.interview.s30.parkinglot;

public interface IParkingLotOperations {

    void park();

    void unPark(int floor, int spot);

    ParkingSpot getNextAvailable();

    void addParkingSpot(int floor, int spot);
}
