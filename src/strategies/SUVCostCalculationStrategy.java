package strategies;

import dto.CostCalculationParams;

import java.time.Duration;

public class SUVCostCalculationStrategy implements CostCalculationStrategy {
    @Override
    public double getCost(CostCalculationParams costCalculationParams) {
        long millis = Duration.between(costCalculationParams.getInTime().toInstant(),
                costCalculationParams.getOutTime().toInstant()).toMillis() / 1000;
        return millis * 40;
    }
}
