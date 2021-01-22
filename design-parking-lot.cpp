/*
m - num of floors, n-num of spots
Time - 
    park() - O(log(mn))
    unpark - O(log(mn)) 
*/
//Space - O(mn) 
class ParkingSpot {
    int floor, spot;
    public:

    ParkingSpot(int floor, int spot){
        this->floor = floor;
        this->spot = spot;
    }

    int getFloor(){
        return this->floor;
    }

    int getSpot(){
        return this->spot;
    }
};

class Comp
{
public:
    bool operator()(ParkingSpot a, ParkingSpot b)
    {
        if(a.getFloor() == b.getFloor()) return a.getSpot()>b.getSpot();
        return a.getFloor() > b.getFloor(); 
    }
};

class ParkingLot {
    int maxFloors,spotsPerFloor;
    
    priority_queue<ParkingSpot, vector<ParkingSpot>, Comp> pq;
    public:
    ParkingLot(int floors,int spots){
        this->maxFloors = floors;
        this->spotsPerFloor = spots;
    }

    void createSpot(int floor, int spot){
        ParkingSpot pspot(floor,spot);
        pq.push(pspot);
    }

    void unParkSpot(int floor, int spot){
        createSpot(floor,spot);
    }

    bool isParkingAvailable(){
        return !pq.empty();
    }

    ParkingSpot getNextSpot(){
        if(!isParkingAvailable()){
            throw invalid_argument( "Parking lot is full!" );
        }
        return pq.top();
    }

    ParkingSpot park(){
        if(!isParkingAvailable()){
            throw invalid_argument( "Parking lot is full!" );
        }
        ParkingSpot pspot = this->pq.top();
        this->pq.pop();
        return pspot;
    }
};

int main() {
    std::cout << "Hello World!\n";
    ParkingLot plot(5,5);
    plot.createSpot(0,0);
    plot.createSpot(0,1);
    plot.createSpot(3,3);
    plot.createSpot(2,1);
    
    ParkingSpot pspot = plot.park();
    cout<<pspot.getFloor()<<" "<<pspot.getSpot()<<endl;
    pspot = plot.park();
    cout<<pspot.getFloor()<<" "<<pspot.getSpot()<<endl;
    pspot = plot.park();
    cout<<pspot.getFloor()<<" "<<pspot.getSpot()<<endl;
    plot.unParkSpot(0,1);
    pspot = plot.park();
    cout<<pspot.getFloor()<<" "<<pspot.getSpot()<<endl;
    
}