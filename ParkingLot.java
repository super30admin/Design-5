
class ParkingLot{
	int MAX_LEVEL, MAX_SPOTS;
	ParkingSpot[] parkingSpots;
	Map<ParkingSpotType,PriorityQueue<ParkingSpot>> pqMap; 
	public ParkingLot(int MAX_LEVEL, int MAX_SPOTS){
		this.MAX_LEVEL = MAX_LEVEL;
		this.MAX_SPOTS = MAX_SPOTS;
		parkingSpots = new ParkingSpot[MAX_LEVEL][MAX_SPOTS];
		pqMap = new HashMap<>();
		prePopulateParkingSpotsReferenceData();
		prePopulatePriorityQueueMapReferenceData();
	}
	public boolean isEmptySpotAvailable(ParkingSpotType parkingType){
		return !pqMap.getOrDefault(parkingType, new PriorityQueue<>()).isEmpty();
	}
	public ParkingSpot getNextEmptySpot(ParkingSpotType parkingType){
		if(!isEmptySpotAvailable(parkingType)){
			return null;
		}
		PriorityQueue<ParkingSpot> pq = pqMap.get(parkingType);
	return !pq.isEmpty()?pq.poll():null;
	}
	public ParkingSpot parkVehicle(Vehicle vehicle){
		ParkingSpot parkingSpot =  getNextEmptySpot(vehicle.getvehicleType());
		if(null == parkingSpot){return parkingSpot;}
		parkingSpot.setVehicleParked(vehicle);
	return parkingSpot;
	}
	public void unParkVehicle(Vehicle vehicle){
		vehicle.getTicket().getParkingSpot().unPark();
		vehicle.unAssignTicket();
		pqMap.get(vehicle.getvehicleType()).offer(vehicle.getTicket().getParkingSpot());
	}
	public Ticket getNewParkingTicket(Vehicle vehicle){
		ParkingSpot parkingSpot = parkVehicle(vehicle);
		if(null == parkingSpot){return null;}
		vehicle.assignTicket();
		vehicle.getTicket().setParkingSpot(parkingSpot);
		return vehicle.getTicket();
	}
}

class Vehicle{
	ParkingSpotType vehicleType;
	String vinNumber, number;
	Ticket ticket;
	public ParkingSpotType getvehicleType(){
		return this.vehicleType;
	}
	public Ticket getTicket(){
		return this.ticket;
	}
	public void assignTicket(){
		this.ticket = generateNewTicket();
	}
	public void unAssignTicket(){
		this.ticket = null;
	}
}

class Ticket{
	int ticketNumber;
	ParkingSpot parkingSpot;
	public ParkingSpot getParkingSpot(){
		return this.parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot){
		this.parkingSpot = parkingSpot;
	}
}

class ParkingSpot implements Comparable{
	int level, spotNumber;
	ParkingSpotType parkingType;
	Vehicle vehicleParked;
	public ParkingSpot(int level, int spotNumber, ParkingSpotType parkingType){
		this.level = level;
		this.spotNumber = spotNumber;
		this.parkingType = parkingType;
	}
	public void setVehicleParked(Vehicle vehicleParked){
		this.vehicleParked = vehicleParked;
	}
	public Vehicle getVehicleParked(){
		return this.vehicleParked;
	}
	public int compareTo(ParkingSpot otherSpot){
		return (this.level*this.level + this.spotNumber*this.spotNumber) - (otherSpot.level*level+otherSpot.spotNumber*otherSpot.spotNumber);
	}
	public void unPark(){
		this.vehicleParked = null;
	}
}
enum ParkingSpotType{
	COMPACT, TRUCK, NORMAL, BIKE;
}