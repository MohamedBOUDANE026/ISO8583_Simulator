package org.sid.transactionservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDTO {
    private String numeroCarte;
    private String codePin;
    private BigDecimal montant;
    private String devise;
    private String typeTransaction;

}
