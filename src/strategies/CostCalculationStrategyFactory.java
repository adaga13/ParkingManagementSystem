package strategies;

import models.enums.VehicleType;

public class CostCalculationStrategyFactory {
    public static CostCalculationStrategy getCostCalculationStrategy(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.BIKE))
            return new BikeCostCalculationStrategy();
        else if (vehicleType.equals(VehicleType.SUV))
            return new SUVCostCalculationStrategy();
        else if (vehicleType.equals(VehicleType.CAR))
            return new CarCostCalculationStrategy();

        throw new RuntimeException("Invalid vehicle type");
    }
}
