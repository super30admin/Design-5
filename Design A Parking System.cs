class ParkingSystem {
    private int _bigSlots =0;
    private int _mediumSlots =0;
    private int _smallSlots=0;
    List<bool> result = new List<bool>();

    public ParkingSystem(int big, int medium, int small) {
        this._bigSlots = big;
        this._mediumSlots = medium;
        this._smallSlots = small;
    }
    
    public bool AddCar(int carType) {
        bool slotsAvailable = false;
        if(carType == 1 && _bigSlots >0 )
        {
            slotsAvailable = true;
            _bigSlots--;
        }
        if(carType == 2 && _mediumSlots >0 )
        {
            slotsAvailable = true;
           _mediumSlots--;
        }
        if(carType == 3 && _smallSlots >0 )
        {
            slotsAvailable = true;
            _smallSlots--;
        }
        return slotsAvailable;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj.AddCar(carType);
 */
