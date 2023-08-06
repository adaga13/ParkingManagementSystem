package strategies;

import dto.CostCalculationParams;

public interface CostCalculationStrategy {

    double getCost(CostCalculationParams costCalculationParams);
}
