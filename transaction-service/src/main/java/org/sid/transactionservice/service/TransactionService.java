package org.sid.transactionservice.service;

import org.sid.transactionservice.dto.ResponseDTO;
import org.sid.transactionservice.dto.TransactionDTO;
import org.sid.transactionservice.feign.PackingISOFeignClient;
import org.sid.transactionservice.feign.ResponseISOFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private PackingISOFeignClient packingClient;

    @Autowired
    private ResponseISOFeignClient responseClient;

    public ResponseDTO processTransaction(TransactionDTO dto) {
        String isoMessage = packingClient.generateIsoMessage(dto);
        String responseCode = responseClient.analyzeIsoMessage(isoMessage);
        return new ResponseDTO(isoMessage, responseCode, "✅ Message analysé et enregistré avec succès");
    }
}
