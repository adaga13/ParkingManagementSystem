package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.enums.SpotStatus;
import models.enums.VehicleType;

@Getter
@Setter
@ToString
public class ParkingSpot {
    private VehicleType supportedVehicleType;

    private int spotNo;

    private int floorNo;

    private SpotStatus spotStatus;

    public ParkingSpot(VehicleType supportedVehicleType, int spotNo, int floorNo) {
        this.supportedVehicleType = supportedVehicleType;
        this.spotNo = spotNo;
        this.floorNo = floorNo;
        this.spotStatus = SpotStatus.AVAILABLE;
    }
}
