#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class ParkingSpace{

    int floor{};
    int spot{};

    public:

    ParkingSpace(int fl,int sp){
        this->floor = fl;
        this->spot = sp;
    }

    int getFloor(){
        return this->floor;
    }

    int getSpot(){
        return this->spot;
    }

    bool operator==(ParkingSpace* p2){
        if(this->floor == p2->getFloor() && this->spot == p2->getSpot()){
            return true;
        }
        return false;
    }

    bool operator>=(ParkingSpace*  p2){
        if(this->floor > p2->getFloor()){
            return true;
        }
        else if(this->floor == p2->getFloor()){
            if(this->spot > p2->getSpot()){
                return true;
            }
        }
        return false;
    }

    bool operator<=(ParkingSpace*  p2){
        if(this->floor < p2->getFloor()){
            return true;
        }
        else if(this->floor == p2->getFloor()){
            if(this->spot < p2->getSpot()){
                return true;
            }
        }
        return false;
    }


};

class Compare{

    bool operator()(ParkingSpace* p1,ParkingSpace* p2){
        if(p1->getFloor()<p2->getFloor()){
            return true;
        }
        else if(p1->getFloor() == p2->getFloor()){
            if(p1->getSpot()<p2->getSpot()){
                return true;
            }
        }
        return false;
    }

};

template<typename T>
class custom_priority_queue : public std::priority_queue<T, std::vector<T>,Compare>
{
  public:

      bool remove(const T& value) {
          auto it = std::find(this->c.begin(), this->c.end(), value);
       
          if (it == this->c.end()) {
              return false;
          }
          if (it == this->c.begin()) {
              // deque the top element
              this->pop();
          }    
          else {
              // remove element and re-heap
              this->c.erase(it);
              std::make_heap(this->c.begin(), this->c.end(), Compare);
         }
         return true;
     }
};

class ParkingLot{

    public:

    int num_floors{};
    int num_spots{};
    custom_priority_queue<ParkingSpace> pq;
    vector<vector<bool>> pq_flag{};

    ParkingLot(int _num_floors,int _num_spots){
        this->num_floors = _num_floors;
        this->num_spots = _num_spots;
        pq_flag.resize(this->num_floors,vector<bool>(this->num_spots,true));
    }

    void addParkingSpace(int fl,int spt){
        if(fl<num_floors && spt<num_spots){
            ParkingSpace p1(fl,spt);
            pq.push(p1);
            pq_flag.at(fl).at(spt) = false;
        }
        else{
            cout<<"Please input the coorect input <"<<this->num_floors<<" and "<<this->num_spots;
        }
    }

    void unpark(int fl,int spt){
        ParkingSpace p1(fl,spt);
        pq.remove(p1);
        pq_flag.at(fl).at(spt) = true;
    }

    ParkingSpace getNext(){
        if(!pq.empty()){
            return pq.top();
        }
        return ParkingSpace(-1,-1);
    }

};