package org.collector.infrastructure.repository;

import org.collector.domain.CycleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleInfoRepository extends JpaRepository<CycleInfo, Long> {
}
