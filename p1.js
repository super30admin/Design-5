class ParkingLot {
    // TODO: Priority Queue class in JavaScript needs to be implemented
    pq = new PriorityQueue((a, b) => {
        if(a.floor === b.floor) {
            return a.spot - b.spot;
        }
        return a.floor - b.floor;
    });
    constructor(maxFloor, maxSpots) {
        this.maxFloor = maxFloor;
        this.maxSpots = maxSpots;
    }
    park(){
        if(this.pq.isEmpty()) {
            console.log('Parking is Full.');
        }
        else {
            return this.pq.poll();
        }
    }
    unpark(floor, spot){
        let newSpot = new ParkingSpot(floor, spot);
        this.pq.add(newSpot);
    }
    getNextAvailable(){
        if(this.pq.isEmpty()) {
            console.log('Parking is Full.');
        }
        else {
            return this.pq.peek();
        }
    }
    addParkingSpot(floor, spot){
        let newSpot = new ParkingSpot(floor, spot);
        this.pq.add(newSpot);
    }
}
class ParkingSpot{
    constructor(floor, spot) {
        this.floor = floor;
        this.spot = spot;
    }
}

let pl = new ParkingLot(10, 20);
pl.addParkingSpot(1, 1);
pl.addParkingSpot(2, 1);
pl.addParkingSpot(3, 1);
pl.addParkingSpot(1, 2);
pl.addParkingSpot(2, 2);
pl.addParkingSpot(3, 2);
let n = pl.getNextAvailable();
console.log("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
pl.park();
let n2 = pl.getNextAvailable();
console.log("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
pl.unpark(1, 1);
let n1 = pl.getNextAvailable();
console.log("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
