package services;

import exceptions.ParkingSpotNotFoundException;
import models.Floor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.SpotStatus;
import models.enums.VehicleType;

public class SlotAllocationService {

    ParkingLot parkingLot;
    public SlotAllocationService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType) throws ParkingSpotNotFoundException {
        for (Floor floor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : floor.getParkingSpots()) {
                if (vehicleType.equals(parkingSpot.getSupportedVehicleType()) &&
                        SpotStatus.AVAILABLE.equals(parkingSpot.getSpotStatus())) {
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFoundException("No parking spot found for vehicle type: " + vehicleType);
    }

    public void bookParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setSpotStatus(SpotStatus.RESERVED);
    }

    public void releaseParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
    }

    public void displayParkingSpots() {
        for (Floor floor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : floor.getParkingSpots()) {
                System.out.println(parkingSpot);
            }
        }
    }
}
