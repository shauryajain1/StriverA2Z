class ParkingSystem {

    int[] availableParkingSpots;
    
    public ParkingSystem(int big, int medium, int small) {
        availableParkingSpots = new int[] {big,medium,small};
    }
    
    public boolean addCar(int carType) {
        if(availableParkingSpots[carType-1] > 0){
            availableParkingSpots[carType-1]--;
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */