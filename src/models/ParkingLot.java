package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ParkingLot {
    private List<Floor> parkingFloors;

    private List<Gate> entryGates;

    private List<Gate> exitGates;

    private String name;

    private String address;

    public void addParkingFloor(Floor floor) {
        parkingFloors.add(floor);
    }

    public void addEntryGate(Gate entryGate) {
        entryGates.add(entryGate);
    }

    public void addExitGate(Gate exitGate) {
        exitGates.add(exitGate);
    }

}
