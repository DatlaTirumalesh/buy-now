package com.aero.insure.payment.service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aero.insure.payment.service.dto.PaymentRequestDto;

import com.aero.insure.payment.service.entity.Payment;
import com.aero.insure.payment.service.entity.PaymentStatus;
import com.aero.insure.payment.service.exception.NoPaymentsFound;
import com.aero.insure.payment.service.exception.PaymentAlreadyDoneException;
import com.aero.insure.payment.service.repo.PaymentRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

	 @Override
	    public Payment makePayment(PaymentRequestDto request) {

	        paymentRepository.findByClaimId(request.getClaimId())
	                .ifPresent(p -> {
	                    throw new PaymentAlreadyDoneException(
	                            "Payment already done for claimId: " + request.getClaimId());
	                });

	        Payment payment = Payment.builder()
	                .claimId(request.getClaimId())
	                .amount(request.getAmount())
	                .status(PaymentStatus.SUCCESS) // simulated success
	                .paymentDate(LocalDate.now())
	                .build();

	        return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		
		if(payments.isEmpty() || payments == null) {
			throw new NoPaymentsFound("Payments are 0");
		}
		return payments;
	}

}
