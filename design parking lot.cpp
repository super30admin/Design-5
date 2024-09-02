//park: O(1)
//getNext: O(1)
//unpark: O(logn)
//addSpot: O(logn)

#include <iostream>
#include <queue>
#include <vector>
#include <stdexcept>

using namespace std;

class ParkingSpot {
public:
    int floor;
    int spot;

    ParkingSpot(int f, int s) : floor(f), spot(s) {}

    // Operator to compare spots in priority queue
    bool operator<(const ParkingSpot& other) const {
        if (floor == other.floor) {
            return spot > other.spot; // Smaller spot number has higher priority
        }
        return floor > other.floor; // Smaller floor number has higher priority
    }

    int getFloor() const { return floor; }
    int getSpot() const { return spot; }
};

class ParkingLot {
private:
    int maxFloors, spotsPerFloor;
    priority_queue<ParkingSpot> pq;

public:
    ParkingLot(int maxFloors, int spotsPerFloor)
        : maxFloors(maxFloors), spotsPerFloor(spotsPerFloor) {}

    void addParkingSpot(int floor, int spot) {
        if (floor > maxFloors) {
            throw invalid_argument("floor input greater than max allowed");
        }
        if (spot > spotsPerFloor) {
            throw invalid_argument("spot input greater than max allowed");
        }
        pq.push(ParkingSpot(floor, spot));
    }

    ParkingSpot park() {
        if (pq.empty()) {
            throw runtime_error("Parking lot is full");
        }
        ParkingSpot topSpot = pq.top();
        pq.pop();
        return topSpot;
    }

    ParkingSpot getNextAvailable() const {
        if (pq.empty()) {
            throw runtime_error("Parking lot is full");
        }
        return pq.top();
    }

    void unpark(int floor, int spot) {
        pq.push(ParkingSpot(floor, spot));
    }
};

int main() {
    ParkingLot pl(10, 20);

    pl.addParkingSpot(1, 1);
    pl.addParkingSpot(2, 1);
    pl.addParkingSpot(3, 1);
    pl.addParkingSpot(1, 2);
    pl.addParkingSpot(2, 2);
    pl.addParkingSpot(3, 2);

    ParkingSpot n = pl.getNextAvailable();
    cout << "Parked at Floor: " << n.getFloor() << ", Slot: " << n.getSpot() << endl;

    pl.park();
    ParkingSpot n2 = pl.getNextAvailable();
    cout << "Parked at Floor: " << n2.getFloor() << ", Slot: " << n2.getSpot() << endl;

    pl.unpark(1, 1);
    ParkingSpot n1 = pl.getNextAvailable();
    cout << "Parked at Floor: " << n1.getFloor() << ", Slot: " << n1.getSpot() << endl;

    return 0;
}
