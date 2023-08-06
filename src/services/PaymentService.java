package services;

import exceptions.PaymentException;
import models.Payment;
import models.enums.PaymentMode;
import models.enums.PaymentStatus;

public class PaymentService {

    public static Payment makePayment(double amount) throws PaymentException {
        return new Payment(PaymentMode.UPI, PaymentStatus.COMPLETED, amount, String.valueOf(Math.random()));
    }
}
