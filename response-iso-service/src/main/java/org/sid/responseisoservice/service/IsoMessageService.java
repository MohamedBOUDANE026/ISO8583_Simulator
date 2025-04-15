package org.sid.responseisoservice.service;

import org.sid.responseisoservice.entity.IsoMessageEntity;
import org.sid.responseisoservice.repository.IsoMessageRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class IsoMessageService {

    private final IsoMessageRepository repository;

    // Constructeur manuel (au lieu de @RequiredArgsConstructor)
    public IsoMessageService(IsoMessageRepository repository) {
        this.repository = repository;
    }

    public void save(String isoMessage) {
        IsoMessageEntity entity = new IsoMessageEntity();
        entity.setMessage(isoMessage);

        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        entity.setReceptionDate(now);

        repository.save(entity);
    }
}
