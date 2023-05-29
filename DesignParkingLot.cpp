#include <iostream>
#include <queue>
using namespace std;

struct ParkingSpot {
    int floor;
    int spot;

public:
    ParkingSpot(int f, int s) {
        floor = f;
        spot = s;
    }

public:
    int getSpot() {
        return spot;
    }

public:
    int getFloor() {
        return floor;
    }
};

struct cmp {
    bool operator()(const ParkingSpot& p1, const ParkingSpot& p2) {
        if (p1.floor == p2.floor)
            return p2.spot < p1.spot;
        else
            return p2.floor < p1.floor;
    }
};

struct ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    priority_queue<ParkingSpot, vector<ParkingSpot>, cmp> pq;

public:
    ParkingLot(int maxF, int spotsPerF) {
        maxFloors = maxF;
        spotsPerFloor = spotsPerF;
    }

public:
    ParkingSpot park() {
        if (pq.empty())
            cout << "Parking Lot is full!" << endl;
        ParkingSpot pS = pq.top();
        pq.pop();
        return pS;
    }

public:
    ParkingSpot getNextAvailable() {
        return pq.top();
    }

public:
    void unpark(int floor, int spot) {
        ParkingSpot vacatedSpot(floor, spot);
        pq.push(vacatedSpot);
    }

public:
    void addParkingSpot(int floor, int spot) {
        if (floor > maxFloors)
            cout << "Invalid Input! Cannot add a spot beyond available space!" << endl;
        if (spot > spotsPerFloor)
            cout << "Invalid Input! Cannot add a spot beyond available space!" << endl;

        ParkingSpot occupyIt(floor, spot);
        pq.push(occupyIt);
    }
};

int main() {
    ParkingLot pL(10, 20);
    pL.addParkingSpot(1, 1);
    pL.addParkingSpot(2, 1);
    pL.addParkingSpot(3, 1);
    pL.addParkingSpot(1, 2);
    pL.addParkingSpot(2, 2);
    pL.addParkingSpot(3, 2);

    ParkingSpot pS = pL.getNextAvailable();
    cout << "Parked at: " << pS.getFloor() << ", Slot: " << pS.getSpot() << endl;
    pL.park();
    ParkingSpot pS2 = pL.getNextAvailable();
    cout << "Parked at: " << pS2.getFloor() << ", Slot: " << pS2.getSpot() << endl;
    pL.unpark(1,1);
    ParkingSpot pS3 = pL.getNextAvailable();
    cout << "Parked at: " << pS3.getFloor() << ", Slot: " << pS3.getSpot() << endl;
    return 0;
}

