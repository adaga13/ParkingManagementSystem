package controllers;

import dto.GenerateInvoiceRequest;
import dto.GenerateTicketRequest;
import dto.GenerateTicketResponse;
import exceptions.ParkingSpotNotFoundException;
import exceptions.PaymentException;
import models.Floor;
import models.Gate;
import models.Invoice;
import models.ParkingLot;
import services.EntryGateService;
import services.ExitGateService;
import services.SlotAllocationService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLot parkingLot;

    private EntryGateService entryGateService;

    private ExitGateService exitGateService;

    private SlotAllocationService slotAllocationService;

    public ParkingLotController(List<Floor> floors, List<Gate> entryGates, List<Gate> exitGates) {
        parkingLot = ParkingLot.builder().name("ParkingLot").address("Central Mall, Pune").
                parkingFloors(floors).entryGates(entryGates).exitGates(exitGates).build();
        slotAllocationService = new SlotAllocationService(parkingLot);
        entryGateService = new EntryGateService(slotAllocationService);
        exitGateService = new ExitGateService(slotAllocationService);
    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequest generateTicketRequest)
            throws ParkingSpotNotFoundException {
        return new GenerateTicketResponse(entryGateService.createTicket(generateTicketRequest));
    }

    public Invoice generateInvoice(GenerateInvoiceRequest generateInvoiceRequest) throws PaymentException {
        return exitGateService.generateInvoice(generateInvoiceRequest);
    }

    public void displayParkingLot() {
        slotAllocationService.displayParkingSpots();
    }
}
