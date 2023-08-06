import controllers.ParkingLotController;
import dto.GenerateInvoiceRequest;
import dto.GenerateTicketRequest;
import exceptions.ParkingSpotNotFoundException;
import exceptions.PaymentException;
import models.*;
import models.enums.GateType;
import models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(0));
        floors.add(new Floor(1));

        floors.get(0).addParkingSpot(new ParkingSpot(VehicleType.CAR, 1, 0));
        floors.get(0).addParkingSpot(new ParkingSpot(VehicleType.BIKE, 2, 0));
        floors.get(1).addParkingSpot(new ParkingSpot(VehicleType.SUV, 1, 1));
        floors.get(1).addParkingSpot(new ParkingSpot(VehicleType.BIKE, 2, 1));

        List<Gate> entryGates = new ArrayList<>();
        entryGates.add(new Gate(GateType.ENTRY, new ParkingAttendant("rahul@gmail.com", "Rahul Sharma")));
        entryGates.add(new Gate(GateType.ENTRY, new ParkingAttendant("sameer@gmail.com", "Sameer Kulkarni")));

        List<Gate> exitGates = new ArrayList<>();
        exitGates.add(new Gate(GateType.EXIT, new ParkingAttendant("feroz@gmail.com", "Feroz Shah")));
        exitGates.add(new Gate(GateType.EXIT, new ParkingAttendant("manish@gmail.com", "Manish Pal")));

        GenerateTicketRequest generateTicketRequest = new GenerateTicketRequest(entryGates.get(0),
                new Vehicle(VehicleType.CAR, "MH012334"));

        ParkingLotController parkingLotController = new ParkingLotController(floors, entryGates, exitGates);

        try {
            Ticket ticket = parkingLotController.generateTicket(generateTicketRequest).getTicket();
            System.out.println("Got ticket: " + ticket);
            parkingLotController.displayParkingLot();
            Thread.sleep(5000);
            System.out.println(parkingLotController.generateInvoice(new GenerateInvoiceRequest(exitGates.get(1), ticket)));
            parkingLotController.displayParkingLot();
            
        } catch (ParkingSpotNotFoundException | PaymentException | InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}