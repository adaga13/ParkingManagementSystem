package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Ticket {

    private String id;

    private Date entryTime;

    private ParkingSpot parkingSpot;

    private Gate entryGate;

    private Vehicle vehicle;

    public Ticket(Gate entryGate, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryGate = entryGate;
        this.vehicle = vehicle;
        this.entryTime = new Date();
        this.parkingSpot = parkingSpot;
        this.id = String.valueOf(Math.random());
    }
}
