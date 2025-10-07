#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We’re using heap to always pick the spot with the lowest floor and lowest spot number.
When someone parks, we remove the best spot from the heap.
If someone unparks, we just add that spot back to the heap again.
*/
class ParkingSpot{
public:
    int floor;
    int spot;

    ParkingSpot(int floor, int spot){
        this->floor = floor;
        this->spot = spot;
    }

    int getSpot(){
        return this->spot;
    }

    int getFloor(){
        return this->floor;
    }

    bool operator<(const ParkingSpot& other) const {
        if(floor == other.floor)
            return spot > other.spot;
        return floor > other.floor;
    }
};
class ParkingLot{
public:
    int maxFloors;
    int spotsPerFloor;
    priority_queue<ParkingSpot> pq;

    ParkingLot(int maxFloors, int spotsPerFloor){
        this->maxFloors = maxFloors;
        this->spotsPerFloor = spotsPerFloor;
    }

    ParkingSpot park(){
        if(pq.empty()){
            throw runtime_error("Eror : Parking lot is full");
        }
        ParkingSpot re = pq.top();
        pq.pop();
        return re;
    }

    void unpark(int floor, int spot){
        ParkingSpot newSpot(floor, spot);
        pq.push(newSpot);
    }

    ParkingSpot getNextAvailable(){
        return pq.top();
    }

    void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw invalid_argument("Error floor input greater than max allowed");
        }
        if(spot > spotsPerFloor){
            throw invalid_argument("Error : spots input greater than max allowed");
        }
        ParkingSpot newSpot(floor, spot);
        pq.push(newSpot);
    }
};

int main(){
    ParkingLot pl(3, 2);
    pl.addParkingSpot(1, 1);
    pl.addParkingSpot(2, 1);
    pl.addParkingSpot(3, 1);
    pl.addParkingSpot(1, 2);
    pl.addParkingSpot(2, 2);
    pl.addParkingSpot(3, 2);
    ParkingSpot n = pl.getNextAvailable();
    cout << "Parked at floor : " << n.getFloor() << ", Slot: " << n.getSpot() << endl;
    pl.park();
    ParkingSpot n2 = pl.getNextAvailable();
    cout << "Parked at floor : " << n2.getFloor() << ", Slot: " << n2.getSpot() << endl;
    pl.unpark(1, 1);
    ParkingSpot n1 = pl.getNextAvailable();
    cout << "Parked at floor: " << n1.getFloor() << ", Slot : " << n1.getSpot() << endl;
    return 0;
}