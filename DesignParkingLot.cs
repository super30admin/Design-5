using System;
using System.Collections.Generic;
using System.Text;

namespace Design
{
    class ParkingLotLC
    {
        //TC: Except for GetAvailableSlots, it is O(logN). For GetAvailableSlots it is O(1)
        //SC: Priority Queue size
        //.NET do not have PriorityQueue in place
        public class ParkingLot
        {
            public int floors, spots;
            PriorityQueue<ParkingSpot> pq;
            public ParkingLot(int floors, int spots)
            {
                this.floors = floors;
                this.spots = spots;
                //pq = new PriorityQueue<ParkingSpot>((a, b) =>
                //                                    {
                //                                        if (a.getFloor() == b.getFloor())
                //                                        {
                //                                            return a.getSpot() - b.getSpot();
                //                                        }
                //                                        return a.getFloor() - b.getFloor();
                //                                    });
            }

            //parking the vehicle
            public ParkingSpot park()
            {
                getAvailableParkingSpot();
                ParkingSpot p = pq.Dequeue();
                return p;
            }

            //getting available parking spots
            public ParkingSpot getAvailableParkingSpot()
            {
                if (pq.Count == 0)
                {
                    throw new Exception("No parking spots are available");
                }
                return pq.Peek();
            }
            //unpark the vehicle
            public void unPark(int floor, int spot)
            {
                if (floor > floors)
                {
                    throw new Exception("Invalid floor");
                }
                if (spot > spots)
                {
                    throw new Exception("Invalid spot");
                }
                pq.Enqueue(new ParkingSpot(floor, spot));
            }
            //add parking space
            public void addParkingSpace(int floor, int spot)
            {
                if (floor > floors)
                {
                    throw new Exception("Invalid floor");
                }
                if (spot > spots)
                {
                    throw new Exception("Invalid spot");
                }
            }
        }

        public  class ParkingSpot
        {
            internal int floor, spot;
            public ParkingSpot(int floor, int spot)
            {
                this.floor = floor;
                this.spot = spot;
            }
            public int getFloor()
            {
                return this.floor;
            }
            public int getSpot()
            {
                return this.spot;
            }
        }

    }
}
