package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Invoice {

    private long invoiceId;

    private Date exitTime;

    private Ticket ticket;

    private double amount;

    private Payment payment;

    private Gate exitGate;

    public Invoice(Ticket ticket, double amount, Payment payment, Gate exitGate, Date exitTime) {
        this.ticket = ticket;
        this.amount = amount;
        this.payment = payment;
        this.exitGate = exitGate;
        this.exitTime = exitTime;
        this.invoiceId = Math.round(Math.random());
    }
}
