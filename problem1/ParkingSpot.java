package problem1;

public class ParkingSpot {
	int floor;
	int spot;
	String token;

	public ParkingSpot(int floor, int spot) {
		this.floor = floor;
		this.spot = spot;
		this.token = new StringBuilder("F").append(floor).append("S").append(spot).toString();
	}

	public int getFloor() {
		return this.floor;
	}

	public int getSpot() {
		return this.spot;
	}

	public String getToken() {
		return token;
	}
}
