// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <queue>
#include <vector>
  
using namespace std;

class ParkingSpot {
public:
    ParkingSpot(int floor, int spot) : floor(floor), spot(spot) {}

    int getSpot() const { return spot; }

    int getFloor() const { return floor; }

private:
    int floor;
    int spot;
};

class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    std::priority_queue<ParkingSpot, std::vector<ParkingSpot>, std::function<bool(const ParkingSpot&, const ParkingSpot&)>> pq =
        std::priority_queue<ParkingSpot, std::vector<ParkingSpot>, std::function<bool(const ParkingSpot&, const ParkingSpot&)>>([](const ParkingSpot& a, const ParkingSpot& b) {
            if (a.getFloor() == b.getFloor())
                return a.getSpot() > b.getSpot();
            return a.getFloor() > b.getFloor();
        });
public:
    ParkingLot(int maxFloors, int spotsPerFloor) : maxFloors(maxFloors), spotsPerFloor(spotsPerFloor) {}

    ParkingSpot park() {
        if (pq.empty()) {
            throw std::runtime_error("Parking lot is full");
        }

        ParkingSpot re = pq.top();
        pq.pop();
        return re;
    }

    ParkingSpot getNextAvailable() {
        if (pq.empty()) {
            throw std::runtime_error("Parking lot is full");
        }

        return pq.top();
    }

    void unpark(int floor, int spot) {
        ParkingSpot newSpot(floor, spot);
        pq.push(newSpot);
    }

    void addParkingSpot(int floor, int spot) {
        if (floor > maxFloors) {
            throw std::invalid_argument("floor input greater than max allowed");
        }

        if (spot > spotsPerFloor) {
            throw std::invalid_argument("spots input greater than max allowed");
        }

        ParkingSpot newSpot(floor, spot);
        pq.push(newSpot);
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
    std::cout << "Parked at Floor: " << n.getFloor() << ", Slot: " << n.getSpot() << std::endl;

    pl.park();

    ParkingSpot n2 = pl.getNextAvailable();
    std::cout << "Parked at Floor: " << n2.getFloor() << ", Slot: " << n2.getSpot() << std::endl;

    pl.unpark(1, 1);

    ParkingSpot n1 = pl.getNextAvailable();
    std::cout << "Parked at Floor: " << n1.getFloor() << ", Slot: " << n1.getSpot() << std::endl;

    return 0;
}
