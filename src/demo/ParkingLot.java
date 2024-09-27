package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ParkingLot {
	private int floors;
	private int spots;
	int x = floors * spots;
	PriorityQueue<ParkingSpace> pq = new PriorityQueue<ParkingLot.ParkingSpace>(x, new Comparator<ParkingSpace>() {

		@Override
		public int compare(ParkingSpace s1, ParkingSpace s2) {
			if(s1.getFloor() == s2.getFloor()) {
				return s1.getSlot() - s2.getSlot();
			}else {
				return s1.getFloor() - s2.getFloor();
			}
		}
	});


	public class ParkingSpace{
		int floor;
		int slot;
		public int getFloor() {
			return floor;
		}
		public void setFloor(int floor) {
			this.floor = floor;
		}
		public int getSlot() {
			return slot;
		}
		public void setSlot(int space) {
			this.slot = space;
		}

		public ParkingSpace(int floor, int slot) {
			this.floor = floor;
			this.slot = slot;
		}

		public ParkingSpace() {
			this.floor = floor;
			this.slot = slot;
		}

		public boolean isFree() {
			if(pq.size()>0) {
				return true;
			}
			return false;
		}

		public ParkingSpace getNext() {
			return pq.peek();
		}

		public ParkingSpace park() {
			pq.remove();
			ParkingSpace p1 =new ParkingSpace();
			p1 = getNext();
			return p1;
		}


		public void unpark(int floor, int slot) {
			ParkingSpace p1 = new ParkingSpace(floor, slot);
			pq.add(p1);
		}

		public int getCost(String slotType, int floor, int time, int rate) {
			if(floor ==0 ) rate =10;
			else if(floor ==1 ) rate = 7;
			else rate =5;
			if(slotType == "Normal" ) ;
			else if(slotType == "Handicap") rate =0;

			int cost = rate * time;
			return cost;
		}


	}
}