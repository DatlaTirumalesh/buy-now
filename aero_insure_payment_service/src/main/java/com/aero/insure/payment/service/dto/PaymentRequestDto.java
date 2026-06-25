package com.aero.insure.payment.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {

    private Long claimId;
    private Double amount;
}
