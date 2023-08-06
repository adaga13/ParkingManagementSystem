package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.enums.VehicleType;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Vehicle {
    private VehicleType vehicleType;

    private String regNumber;
}
