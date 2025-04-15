package org.sid.responseisoservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IsoMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String message;  // Le message ISO brut

    private String receptionDate;
}
