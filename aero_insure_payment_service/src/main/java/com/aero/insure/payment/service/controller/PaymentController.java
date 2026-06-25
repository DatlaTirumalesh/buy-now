package com.aero.insure.payment.service.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aero.insure.payment.service.dto.PaymentRequestDto;
import com.aero.insure.payment.service.entity.Payment;
import com.aero.insure.payment.service.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // URL: POST http://localhost:8080/api/payments/process
    @PostMapping("/process") 
    public Payment makePayment(@RequestBody PaymentRequestDto request) {
        return paymentService.makePayment(request);
    }
    
    // URL: GET http://localhost:8080/api/payments/payments
    @GetMapping("/getAllPayments")
    public ResponseEntity<List<Payment>> getPayments() {
    	return ResponseEntity.ok(paymentService.getAllPayments());
    }
}