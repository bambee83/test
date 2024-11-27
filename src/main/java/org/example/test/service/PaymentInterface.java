package org.example.test.service;

import org.example.test.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
