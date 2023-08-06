package dto;

import models.Gate;
import models.Ticket;

public class GenerateInvoiceRequest {

    private Gate exitGate;

    private Ticket ticket;

    public GenerateInvoiceRequest(Gate exitGate, Ticket ticket) {
        this.exitGate = exitGate;
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
