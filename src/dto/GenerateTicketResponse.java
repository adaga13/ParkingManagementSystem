package dto;

import models.Ticket;

public class GenerateTicketResponse {
    Ticket ticket;

    public GenerateTicketResponse(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
