
import java.time.Duration;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.UUID;
import java.util.Comparator;


public class ParkingSpace {

    int maxSpots;
    int parkingFees;
    Map<UUID,Spot> occupied;
    int floors;
    int spaces;
    PriorityQueue<Spot> availableSpots;

    ParkingSpace(int parkingFees,int floors,int spaces){
        this.maxSpots = maxSpots;
        this.parkingFees = parkingFees;

        this.floors = floors;
        this.spaces = spaces;
        maxSpots=floors*spaces;
        Comparator<Spot> customComparator = new Comparator<Spot>(){
            public int compare(Spot a , Spot b){
                if(a.floor<b.floor) return a.floor-b.floor;
                return a.spotNumber-b.spotNumber;
            }
        };
        availableSpots = new PriorityQueue(customComparator);
        for(int i=0;i<floors;i++){
            for(int j = 0;j<spaces;j++){
                Spot spot = new Spot(i,j);
                availableSpots.add(spot);
            }
        }
        occupied = new HashMap<>();

    }
    private Ticket getTicket(){
        if(!availableSpots.isEmpty()){
            Spot used = availableSpots.poll();
            occupied.put(used.id,used);
//            System.out.println(used.floor);
//            System.out.println(used.spotNumber);
            Ticket ticket = new Ticket(used.id);
            maxSpots--;
            return ticket;

        }
        System.out.println("Parking Full!!");
        return null;
    }
    private int checkOut(Ticket ticket){
        if(occupied.containsKey(ticket.id)){
            Spot spot = occupied.get(ticket.id);
            occupied.remove(ticket.id);
            availableSpots.add(spot);
            ticket.outTime = LocalDateTime.now();
            if(ticket.outTime!=null){
                Duration diff = Duration.between( ticket.inTime,ticket.outTime);
//                System.out.println(diff);
                ticket.cost = (int)diff.getSeconds()*parkingFees;
                ticket.paid=true;
            }
            maxSpots++;
            return ticket.cost;
        }
        System.out.println("Invalid Ticket");
        return 0;
    }
    private int availability(){
        return maxSpots;
    }

    public static void main(String[] args) {
    ParkingSpace p = new ParkingSpace(2,2,2);
        System.out.println(p.availability());
        Ticket t = p.getTicket();
//        System.out.println(p.availability());

//        System.out.println(t.inTime);
//        try
//        {
//            Thread.sleep(10000);
//        }
//        catch(InterruptedException ex)
//        {
//            Thread.currentThread().interrupt();
//        }
        int cost = p.checkOut(t);
//        System.out.println(t.cost);
    }

}
class Spot{
    UUID id;

    int floor;
    int spotNumber;
    Spot(int floor, int spotNumber){
        this.floor = floor;
        this.spotNumber = spotNumber;
        id = new  UUID(floor,spotNumber);
    }
}
class Ticket{
    int cost;
    LocalDateTime inTime;
    LocalDateTime outTime;
    Boolean paid;
    UUID id;
    Ticket(UUID id){
        this.id = id;
        inTime = LocalDateTime.now();
    }
}
