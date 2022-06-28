package com.interview.s30.parkinglot;

import java.util.PriorityQueue;

public class ParkingLot implements IParkingLotOperations
{
    PriorityQueue<ParkingSpot> priorityQueue;

    public ParkingLot()
    {
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void park()
    {
        priorityQueue.poll();
    }

    @Override
    public void unPark(int floor, int spot)
    {
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        priorityQueue.add(parkingSpot);
    }

    @Override
    public ParkingSpot getNextAvailable()
    {
        return priorityQueue.peek();
    }

    @Override
    public void addParkingSpot(int floor, int spot)
    {
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        priorityQueue.add(parkingSpot);
    }

    public static void main(String argv[])
    {
        System.out.println("Hello World from Parking Lot");

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.addParkingSpot(1,1);
        parkingLot.addParkingSpot(2,1);
        parkingLot.addParkingSpot(3,1);
        parkingLot.addParkingSpot(1,2);
        parkingLot.addParkingSpot(2,2);
        parkingLot.addParkingSpot(3,2);

        ParkingSpot parkingSpot = parkingLot.getNextAvailable();
        System.out.println("Parking at " + parkingSpot);

        parkingLot.park();

        parkingSpot = parkingLot.getNextAvailable();
        System.out.println("Parking at " + parkingSpot);

        parkingLot.unPark(1,1);

        parkingSpot = parkingLot.getNextAvailable();
        System.out.println("Parking at " + parkingSpot);
    }
}
