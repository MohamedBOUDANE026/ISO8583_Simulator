package org.sid.packingisoservice.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class TransactionDTO {
    private String numeroCarte;
    private String codePin;
    private BigDecimal montant;
    private String devise;
    private String typeTransaction;
}
