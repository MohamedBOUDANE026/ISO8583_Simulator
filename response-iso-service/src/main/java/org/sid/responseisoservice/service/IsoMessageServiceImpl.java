package org.sid.responseisoservice.service;

import lombok.RequiredArgsConstructor;
import org.sid.responseisoservice.entity.IsoMessageEntity;
import org.sid.responseisoservice.repository.IsoMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IsoMessageServiceImpl implements IsoMessageService {
    private final IsoMessageRepository repository;

    @Override
    public void save(String isoMessage) {
        String responseCode = analyze(isoMessage); // analyser ici
        IsoMessageEntity entity = IsoMessageEntity.builder()
                .rawMessage(isoMessage)
                .responseCode(responseCode)
                .dateReception(LocalDateTime.now())
                .build();
        repository.save(entity);
    }

    @Override
    public String analyze(String isoMessage) {
        if (isoMessage == null || isoMessage.isEmpty()) {
            return "96"; // Code 96 : Erreur système
        }

        // 🧠 Extraire les 2 derniers caractères du message pour simuler un "response code"
        String responseCode;

        if (isoMessage.length() >= 2) {
            responseCode = isoMessage.substring(isoMessage.length() - 2);
        } else {
            return "96";
        }

        // 🎯 Interprétation des codes ISO les plus connus
        switch (responseCode) {
            case "00":
                return "00"; // Succès
            case "01":
                return "01"; // Référer au titulaire de la carte
            case "05":
                return "05"; // Ne pas honorer
            case "12":
                return "12"; // Transaction invalide
            case "13":
                return "13"; // Montant invalide
            case "14":
                return "14"; // Numéro de carte invalide
            case "30":
                return "30"; // Erreur de format
            case "41":
                return "41"; // Carte perdue
            case "43":
                return "43"; // Carte volée
            case "51":
                return "51"; // Fonds insuffisants
            case "54":
                return "54"; // Carte expirée
            case "55":
                return "55"; // Code PIN incorrect
            case "57":
                return "57"; // Transaction non autorisée
            case "58":
                return "58"; // Terminal non autorisé
            case "91":
                return "91"; // Émetteur indisponible
            case "94":
                return "94"; // Transaction en double
            case "96":
                return "96"; // Erreur système
            default:
                return "XX"; // Code inconnu
        }
    }
}
