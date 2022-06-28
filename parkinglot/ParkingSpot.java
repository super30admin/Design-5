package com.interview.s30.parkinglot;

public class ParkingSpot implements Comparable<ParkingSpot>
{
    private int floor;
    private int spot;

    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpot() {
        return spot;
    }

    @Override
    public int compareTo(ParkingSpot o) {
        if(floor == o.floor)
            return spot - o.spot;

        return floor - o.floor;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "floor=" + floor +
                ", spot=" + spot +
                '}';
    }
}
