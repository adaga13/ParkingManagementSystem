package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.enums.PaymentMode;
import models.enums.PaymentStatus;

@Getter
@Setter
@ToString
public class Payment {
    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    private double amount;

    private String reference;

    public Payment(PaymentMode paymentMode, PaymentStatus paymentStatus, double amount, String reference) {
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.reference = reference;
    }
}
