package repositories;

import models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> ticketList;

    public TicketRepository() {
        ticketList = new ArrayList<>();
    }

    public void saveTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public Ticket getTicketById(String ticketId) {
        return ticketList.stream().filter(ticket -> ticket.getId().equals(ticketId)).findFirst().orElse(null);
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }
}
