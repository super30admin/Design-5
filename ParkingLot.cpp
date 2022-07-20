// Time Complexity :
//      Operations of ParkingLot class -> O(log n) (availableSpot() -> O(1))
//      Operations of ParkingSpot class -> O(1) 
// Space Complexity : O(n)
//      Where n : number of available spots.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Create two classes for lot and spot. 
 * For park and unpark operation use min heap to maintain next available spot.
 */

#include <iostream>
#include <queue>

using namespace std;

class ParkingSpot{
    int floor, spot;
    
    public:
        ParkingSpot(int floor, int spot) : floor(floor), spot(spot) {}
        int getFloor() const {return floor;};
        int getSpot() const {return spot;};
};

class Compare{
    public:
        bool operator() (const ParkingSpot& a, const ParkingSpot& b) const {
            if (a.getFloor() == b.getFloor())
            {
                return a.getSpot() > b.getSpot();
            }

            return a.getFloor() > b.getFloor();
        }
};

class ParkingLot{
    int maxFloor, maxSpot;
    priority_queue<ParkingSpot, vector<ParkingSpot>, Compare> pq;
        
    public :
        ParkingLot(int floor, int spot) : maxFloor(floor), maxSpot(spot){ }
    
        bool addParkingSpot(int floor, int spot)
        {
            if (floor > maxFloor || spot > maxSpot)
            {
                return false;
            }

            pq.emplace(floor, spot);
            return true;
        }

        ParkingSpot park()
        {
            if (pq.empty())
            {
                return ParkingSpot(-1, -1);

            }
            ParkingSpot spot = pq.top();
            pq.pop();

            return spot;           
        }

        void unPark(int floor, int spot)
        {
            pq.emplace(floor, spot);
        }

        ParkingSpot availableSpot()
        {
            if (pq.empty())
            {
                return ParkingSpot(-1, -1);

            }
            ParkingSpot spot = pq.top();
            return spot;
        }
};

int main() {
    ParkingLot lot(10, 10);
    lot.addParkingSpot(0, 1);
    lot.addParkingSpot(0, 5);
    lot.addParkingSpot(5, 7);
    lot.addParkingSpot(2, 5);
    lot.addParkingSpot(4, 1);

    ParkingSpot spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

    spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

    spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

    spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

    spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

    lot.unPark(2, 5);
    spot = lot.park();
    cout << "Parked at floor :" << spot.getFloor() << " , spot :- " << spot.getSpot() << "\n";

}