package org.sid.responseisoservice.controller;

import lombok.RequiredArgsConstructor;
import org.sid.responseisoservice.service.IsoMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/response")
@RequiredArgsConstructor
public class IsoMessageController {
    private final IsoMessageService isoMessageService;

    @PostMapping("/save")
    public String saveMessage(@RequestBody String isoMessage) {
        isoMessageService.save(isoMessage);
        return "✅ Message ISO reçu, analysé et stocké avec succès !";
    }
}