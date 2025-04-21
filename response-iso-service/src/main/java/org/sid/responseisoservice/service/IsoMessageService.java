package org.sid.responseisoservice.service;

public interface IsoMessageService {
    void save(String isoMessage);
    String analyze(String isoMessage);
}
