package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.enums.GateType;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Gate {

    private GateType gateType;

    private ParkingAttendant parkingAttendant;

}
