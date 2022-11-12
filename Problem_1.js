// Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
// When someone leave you need update this space as empty. 
// What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time. => Priority Queue

// add Parking
// Time Complexity : O(logn)
// Space Complexity : O(n)

// get Parking
// Time Complexity : O(logn)
// Space Complexity : O(n)

// getNextAvailableParking
// Time Complexity : O(1)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes Ran locally
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class PQ {
    constructor(comparision) {
        this.compare = comparision;
        this.pq = new Array();
    }
    swap(idx1, idx2) {
        let temp = this.pq[idx1];
        this.pq[idx1] = this.pq[idx2];
        this.pq[idx2] = temp;
    }
    add(data) {
        this.pq.push(data);
        let i = this.pq.length - 1;
        let parent = Math.floor((i - 1) / 2);
        while (parent >= 0) {
            if (this.compare(this.pq[parent], this.pq[i]) > 0) {
                this.swap(parent, i)
                i = parent;
                parent = Math.floor((i - 1) / 2);
            } else {
                break;
            }
        }
    }
    poll() {
        if (pq.length === 0)
            return "Empty array"

        this.swap(0, this.pq.length - 1);
        let temp = this.pq.pop();
        let n = this.pq.length
        // children : 2i+1 & 2i+2
        let parent = 0;
        let child1 = (2 * parent) + 1;
        let child2 = (2 * parent) + 2;
        while (child1 < n) {
            if (child2 < n && (this.compare(this.pq[parent], this.pq[child1]) > 0 || this.compare(this.pq[parent], this.pq[child2]) > 0)) {
                if (this.compare(this.pq[child2], this.pq[child1]) > 0) {
                    // Child1 is smaller
                    this.swap(parent, child1);
                    parent = child1;
                } else {
                    this.swap(parent, child2);
                    parent = child2;
                }
            } else if (this.compare(this.pq[parent], this.pq[child1]) > 0) {
                // Child1 is smaller
                this.swap(parent, child1);
                parent = child1;
            } else {
                break;
            }
            child1 = (2 * parent) + 1;
            child2 = (2 * parent) + 2;
        }
        return temp;
    }
    peek() {
        if (pq.length === 0)
            return "No availability"
        return this.pq[0];
    }
    getLength() { return this.pq.length; }
}

let pq = new PQ((a, b) => {
    if (a.floor === b.floor) {
        return a.spot - b.spot;
    }
    return a.floor - b.floor;
})

class ParkingLot {
    constructor(maxFloors, maxSpots) {
        this.maxFloors = maxFloors
        this.maxSpots = maxSpots
        this.pq = new PQ((a, b) => {
            if (a.floor === b.floor) {
                return a.spot - b.spot;
            }
            return a.floor - b.floor;
        })
    }
    addParking(floor, spot) {
        if (floor > this.maxFloors) {
            console.log("Please enter valid floor")
            return;
        }
        if (spot > this.maxSpots) {
            console.log("Please enter valid spot")
            return;
        }
        let ps = new ParkingSpot(floor, spot);
        this.pq.add(ps);
    }
    getParking() {
        if (this.pq.getLength() === 0) {
            console.log("Parking is full")
            return;
        }
        return this.pq.poll();
    }
    getNextAvailableParking() {
        if (this.pq.getLength === 0) {
            console.log("Parking is not available")
            return;
        }
        return this.pq.peek();
    }
}
class ParkingSpot {
    constructor(floor, spot) {
        this.floor = floor;
        this.spot = spot
    }
    getParkingFloor() {
        return this.floor;
    }
    getParkingSpot() {
        return this.spot;
    }
}

let parkingLot = new ParkingLot(10, 5);
parkingLot.addParking(2, 2)
parkingLot.addParking(2, 1)
parkingLot.addParking(0, 0)
parkingLot.addParking(1, 1)
parkingLot.addParking(3, 3)
parkingLot.addParking(1, 2)
parkingLot.addParking(3, 2)
parkingLot.addParking(1, 3)
parkingLot.addParking(3, 4)
parkingLot.addParking(4, 2)
parkingLot.addParking(3, 1)

console.log("Parking: ", parkingLot.getParking())

console.log("Next available: ", parkingLot.getNextAvailableParking())

console.log("Parking: ", parkingLot.getParking())

console.log("Parking: ", parkingLot.getParking())
