TC - O(N)
SC - O(N)

/**
 * @param {number} big
 * @param {number} medium
 * @param {number} small
 */
var spot=[];
var ParkingSystem = function(big, medium, small) {
    spot=[0,big,medium,small];
    
};

/** 
 * @param {number} carType
 * @return {boolean}
 */
ParkingSystem.prototype.addCar = function(carType) {
    if(spot[carType]>0)
    {
        spot[carType]--;
        return true;
    }
    else
        return false;
};