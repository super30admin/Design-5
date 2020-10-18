

    /*  Explanation
    Leetcode problem link : https://www.careercup.com/question?id=5084295966228480
    Time Complexity  : o(n) 
    Extra Space Complexity : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
    Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Maintain the entry of each slot in the priority queue.
                    B) for available slot, return top element of min heap.
                    C) for parking, remove from min heap and add it into hashset.
                    D) for removing from poarking, add agauin into Min heap and remove from hashset
                    E) Hashset required to give number of available slots
    */  

import java.util.*;
class design_parking_lot{


    private static int availableSlot(){
        return pq.size() > 0 ? pq.peek() : -1;
    }

    private static void park_vehicle(int parking){
        if(parking > 10){
            System.out.println("Invalid Parking ID");
            return;
        }
        pq.remove(parking);
        hashSet.add(parking);
    }
    
    private static void remove_park_vehicle(int parking){
            pq.add(parking);
            hashSet.remove(hashSet);
    }

    private static int number_of_vehicles_parked(){
            return hashSet.size();
    }

    private static int total_space_available(){
            return 10 - hashSet.size();
    }

    static HashSet<Integer> hashSet = new HashSet<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

    public static void main(String[] args){
        // 10 slots
        for(int i=1;i<11;i++){
            pq.add(i);
        }
            System.out.println(availableSlot());
            park_vehicle(1);
            System.out.println(availableSlot());
            park_vehicle(2);
            System.out.println(availableSlot());
            park_vehicle(15);
            System.out.println(availableSlot());
            remove_park_vehicle(1);
            System.out.println(availableSlot());
            park_vehicle(3);
            System.out.println(pq);
            System.out.println(" Number Of Vehicles Parked = "+number_of_vehicles_parked());
            System.out.println(" Remaining Number Of Slots = "+total_space_available());
    }
}