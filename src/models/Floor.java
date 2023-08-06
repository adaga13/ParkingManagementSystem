package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor {

    int floorNo;

    List<ParkingSpot> parkingSpots;

    public Floor(int floorNo) {
        this.floorNo = floorNo;
        parkingSpots = new ArrayList<>();
    }
    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }
}
