package com.aero.insure.payment.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aero.insure.payment.service.entity.Payment;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByClaimId(Long claimId);
}
