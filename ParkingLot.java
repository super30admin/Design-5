import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ParkingLot {
	private int capacity;

	private PriorityQueue<ParkingSlot> pq;
	private Set<ParkingSlot> occupiedSet;

	public ParkingLot(int capacity) {
		this.capacity = capacity;
		pq = new PriorityQueue<ParkingSlot>(capacity, (ps1, ps2) -> ps1.getSlot() - ps2.getSlot());
		occupiedSet = new HashSet<>(capacity);
	}

	public ParkingSlot park() {
		ParkingSlot ps = getNextAvailable();
		if (ps == null) {
			throw new IllegalStateException("Parking Lot is Full.");
		}

		pq.remove(ps);
		occupiedSet.add(ps);
		return ps;
	}

	public void unpark(int slot) {
		ParkingSlot ps = new ParkingSlot(slot);
		if (occupiedSet.contains(ps)) {
			pq.add(ps);
			occupiedSet.remove(ps);
		} else {
			throw new IllegalStateException("Invalid Parking Slot.");
		}
	}

	public int getCurrentOccupiedCount() {
		return occupiedSet.size();
	}

	public void addParkingSlot(int slot) {
		ParkingSlot ps = new ParkingSlot(slot);
		pq.add(ps);
	}

	public ParkingSlot getNextAvailable() {
		if (pq.size() > 0) {
			return pq.peek();
		}
		return null;
	}

	public static void main(String[] args) {

		ParkingLot pl = new ParkingLot(100);

		for (int i = 1; i <= 100; i++) {
			pl.addParkingSlot(i);
		}

		ParkingSlot n = pl.park();
		System.out.println("Parked at  Slot: " + n.getSlot());
		
		ParkingSlot n1 = pl.park();
		System.out.println("Parked at  Slot: " + n1.getSlot());
		
		System.out.println("current count:"+pl.getCurrentOccupiedCount());
		pl.unpark(n.getSlot());
		pl.unpark(n1.getSlot());
		System.out.println("current count:"+pl.getCurrentOccupiedCount());

	}

	public class ParkingSlot {
		private int slot;

		public int getSlot() {
			return slot;
		}

		public ParkingSlot(int slot) {
			if (slot > capacity) {
				throw new IllegalArgumentException("Capacity is " + capacity + " slots.");
			}
			this.slot = slot;
		}

		@Override
		public boolean equals(Object obj) {
			ParkingSlot ps = (ParkingSlot) obj;
			return (this.getSlot() == ps.getSlot());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + slot;
			return result;
		}
	}
}
