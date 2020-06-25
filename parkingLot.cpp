// Time Complexity : O(1) for parking, O(log(mn)) for unparking; m=floors, n=spots/floor
// Space Complexity : O(mn) - set
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain an ordered set as the occupancy map; add floor*10 + spot into it 
// 2. Park will just remove first element from set while unpark will add floor-spot combo to set
// 3. getNextAvailable() will return the next available parking spot available 

class ParkingSpot{
private:
    int floor_;
    int spot_;
public:
    ParkingSpot (int floor, int spot){
        floor_ = floor;
        spot_=spot;
    }
    
    int getFloor(){
        return floor_;
    }
    
    int getSpot(){
        return spot_;
    }
};

class ParkingLot {
private:
    int maxFloors;
    int spotsPerFloor;
    set<int> available;
public:
    ParkingLot(int floors, int spots){
        maxFloors = floors;
        spotsPerFloor = spots;
    }
    
    void addParkingSpot(int floor, int spot){
        unpark(floor, spot);
    }
    
    void park(){
        available.erase(available.begin());
    }
    
    void unpark(int floor, int spot){
        int val = floor*10 + spot;
        available.insert(val);
    }
    
    ParkingSpot* getNextAvailable(){
        int value = *available.begin();
        int floor = value/10;
        int spot = value%10;
        return new ParkingSpot(floor, spot);
    }
};


int main () {
    ParkingLot pl (10, 20);
    pl.addParkingSpot(1, 1);
    pl.addParkingSpot(2, 1);
    pl.addParkingSpot(3, 1);
    pl.addParkingSpot(1, 2);
    pl.addParkingSpot(2, 2);
    pl.addParkingSpot(3, 2);
    
//     ParkingSpot* n1 = pl.getNextAvailable();
//     cout<<"Parked at floor "<<n1->getFloor()<<", Slot: "<<n1->getSpot()<<endl;
//     pl.park();
//     ParkingSpot* n2 = pl.getNextAvailable();
//     cout<<"Parked at floor "<<n2->getFloor()<<", Slot: "<<n2->getSpot()<<endl;
//     pl.unpark(1, 2);
//     ParkingSpot* n3 = pl.getNextAvailable();
//     cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    
    ParkingSpot* n3 = nullptr;
    n3 = pl.getNextAvailable();
    cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    pl.park();
    
    n3 = pl.getNextAvailable();
    cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    pl.park();
    
    n3 = pl.getNextAvailable();
    cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    pl.park();
    
    n3 = pl.getNextAvailable();
    cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    pl.park();
    
    n3 = pl.getNextAvailable();
    cout<<"Parked at floor "<<n3->getFloor()<<", Slot: "<<n3->getSpot()<<endl;
    pl.park();
    return 0;
}