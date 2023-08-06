package services;

import dto.GenerateTicketRequest;
import exceptions.ParkingSpotNotFoundException;
import models.Gate;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import repositories.TicketRepository;

public class EntryGateService {

    SlotAllocationService slotAllocationService;

    TicketRepository ticketRepository;

    public EntryGateService(SlotAllocationService slotAllocationService) {
        this.slotAllocationService = slotAllocationService;
    }

    public Ticket createTicket(GenerateTicketRequest generateTicketRequest) throws ParkingSpotNotFoundException {
        Gate entryGate = generateTicketRequest.getEntryGate();
        Vehicle vehicle = generateTicketRequest.getVehicle();
        ParkingSpot parkingSpot = slotAllocationService.findParkingSpot(vehicle.getVehicleType());
        slotAllocationService.bookParkingSpot(parkingSpot);
        Ticket ticket = new Ticket(entryGate, vehicle, parkingSpot);
        ticketRepository.saveTicket(ticket);
        return ticket;
    }
}
