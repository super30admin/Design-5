
/*
The idea is to first think about the high level entities first. Here it is a parking lot. 
Is the parking lot 2d or 1d?
In which order do we want the new spaces?
Can spaces be added after being removed?
We can get the first element using a min heap
///////////////////////////////////////////
addParkingSpot()
Time Complexity : O(N log N ) heapify is happening
///////////////////////////////////////////
unPark() uses addParkingSpot() method
Time Complexity : O(N log N ) heapify is happening
///////////////////////////////////////////
getNextAvailable
Time Complexity : O(1) Peeks at the top
///////////////////////////////////////////
Total Space Complexity: O(Floors*Spots) = Size 0f heap
*/


#include<iostream>
#include<queue>
#include<vector>
using namespace std;

class ParkingSpot{
    public:
        int floor;
        int spot;
        ParkingSpot(int Floor, int Spot){
            floor = Floor;
            spot = Spot;
        }
        int getFloor(){
            return this->floor;
        }
        int getSpot(){
            return this->spot;
        }

};
class ParkingLot{
    struct comparator{
        bool operator()(ParkingSpot* p1, ParkingSpot* p2){
            if ( p1->floor == p2->floor) 
                return p1->spot > p2->spot;
            return p1->floor > p2->floor;
        }
    };
    public: 
        int maxFloors;
        int maxSpots;
        priority_queue<ParkingSpot*, vector<ParkingSpot*>, comparator>pq;


        ParkingLot(int Floors, int Spots){
            maxFloors = Floors;
            maxSpots = Spots;
        }
        void addParkingSpot(int floor, int spot){
            if ( floor > maxFloors){
                throw "given input is greather than the number of max floors";

            }
            if ( spot > maxSpots){
                throw "given input is greather than the number of max spots";
            }
            auto ps = new ParkingSpot(floor, spot);
            pq.push(ps);
            
        }
        void unPark(int floor, int spot){
            addParkingSpot(floor, spot);
        }
        ParkingSpot* park(){
            auto spot = getNextAvailable();
            pq.pop();
            return spot;
        }
        ParkingSpot* getNextAvailable(){
            if ( pq.size() == 0){
                throw "No Availble spots";
            }
            return pq.top();
        }
    
};

int main(){
    auto p1 = new ParkingLot(10,20);
    p1->addParkingSpot(1,1);
    p1->addParkingSpot(2,1);
    p1->addParkingSpot(3,1);
    p1->addParkingSpot(1,2);
    p1->addParkingSpot(2,2);
    p1->addParkingSpot(3,2);
    auto n = p1->getNextAvailable();
    cout<<"Parked at floor: "<<n->getFloor()<<", Slot: "<<n->getSpot()<<endl;
    p1->park();
    auto n2 = p1->getNextAvailable();
    cout<<"Parked at floor: "<<n2->getFloor()<<", Slot: "<<n2->getSpot()<<endl;
    p1->unPark(1,1);
    auto n1 = p1->getNextAvailable();
    cout<<"Parked at floor: "<<n1->getFloor()<<", Slot: "<<n1->getSpot()<<endl;
}