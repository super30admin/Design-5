// TC: O(1)
// SC: O(1)
class ParkingSystem {
    private int TYPE_BIG = 1;
    private int TYPE_MED = 2;
    private int TYPE_SMALL = 3;
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == TYPE_SMALL && small > 0) {
            small--;
            return true;
        } else if (carType == TYPE_MED && medium > 0) {
            medium--;
            return true;
        } else if (carType == TYPE_BIG && big > 0) {
            big--;
            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */