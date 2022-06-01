import java.sql.Date;

//using minHeap to find nearest parking spot

public class ParkingSystem {

    public void name() {

    }
}

class Ticket {
    int parkingId;
    int vehicalId;
    Date tDate;
    ParkingSpot ps;
    int rate;

    public int checkOut() {

        ps.exitSpot();
        return (new Date().getTime() - tDate.getTime()) * rate;
    }
}

class ParkingSpot {
    int id;
    boolean isEmpty;
    int distEntrance;

    public ParkingSpot(int id, boolean isEmpty, int distEntrance) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.distEntrance = distEntrance;
    }

    public void exitSpot() {
        this.isEmpty = true;
    }
}
