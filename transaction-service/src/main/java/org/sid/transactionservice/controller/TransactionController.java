package org.sid.transactionservice.controller;

import org.sid.transactionservice.dto.ResponseDTO;
import org.sid.transactionservice.dto.TransactionDTO;
import org.sid.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transaction")


    public class TransactionController {

        @Autowired
        private TransactionService transactionService;

     @PostMapping("/process")
    public ResponseEntity<ResponseDTO> processTransaction(@RequestBody TransactionDTO dto) {
        ResponseDTO response = transactionService.processTransaction(dto);
        return ResponseEntity.ok(response);
    }
}
