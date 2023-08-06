package services;

import dto.CostCalculationParams;
import dto.GenerateInvoiceRequest;
import exceptions.PaymentException;
import models.*;
import models.enums.VehicleType;
import strategies.CostCalculationStrategy;
import strategies.CostCalculationStrategyFactory;

import java.util.Date;

public class ExitGateService {

    SlotAllocationService slotAllocationService;
    public ExitGateService(SlotAllocationService slotAllocationService) {
        this.slotAllocationService = slotAllocationService;
    }

    public Invoice generateInvoice(GenerateInvoiceRequest generateInvoiceRequest) throws PaymentException {
        Gate exitGate = generateInvoiceRequest.getExitGate();
        Ticket ticket = generateInvoiceRequest.getTicket();
        Date exitTime = new Date();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        double amount = CostCalculationStrategyFactory.getCostCalculationStrategy(vehicleType)
                .getCost(new CostCalculationParams(ticket.getEntryTime(), exitTime, vehicleType));
        Payment payment = PaymentService.makePayment(amount);
        releaseParkingSpot(ticket.getParkingSpot());
        return new Invoice(ticket, amount, payment, exitGate, exitTime);
    }

    private void releaseParkingSpot(ParkingSpot parkingSpot) {
        slotAllocationService.releaseParkingSpot(parkingSpot);
    }
}
