package dto;

import models.enums.VehicleType;

import java.util.Date;

public class CostCalculationParams {

    private Date inTime;

    private Date outTime;

    private VehicleType vehicleType;

    public CostCalculationParams(Date inTime, Date outTime, VehicleType vehicleType) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.vehicleType = vehicleType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
