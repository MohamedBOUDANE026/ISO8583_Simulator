package org.sid.packingisoservice.controller;

import lombok.RequiredArgsConstructor;
import org.sid.packingisoservice.dto.TransactionDTO;
import org.sid.packingisoservice.service.IsoMessageGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/iso")
@RequiredArgsConstructor
public class IsoController {

    private final IsoMessageGeneratorService isoService;

    @PostMapping("/generate")
    public ResponseEntity<String> generate(@RequestBody TransactionDTO dto) {
        try {
            String iso = isoService.generateIsoMessage(dto);
            return ResponseEntity.ok(iso);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur ISO : " + e.getMessage());
        }
    }
}
