package org.sid.responseisoservice.repository;

import org.sid.responseisoservice.entity.IsoMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsoMessageRepository extends JpaRepository<IsoMessageEntity, Long> {
}
