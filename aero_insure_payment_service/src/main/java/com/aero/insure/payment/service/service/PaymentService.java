package com.aero.insure.payment.service.service;

import com.aero.insure.payment.service.dto.PaymentRequestDto;
import java.util.*;
import com.aero.insure.payment.service.entity.Payment;

public interface PaymentService {

    Payment makePayment(PaymentRequestDto request);
    List<Payment> getAllPayments();
}
