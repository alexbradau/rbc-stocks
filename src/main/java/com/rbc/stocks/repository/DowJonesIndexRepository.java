package com.rbc.stocks.repository;

import com.rbc.stocks.domain.DowJonesIndex;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DowJonesIndex entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DowJonesIndexRepository extends JpaRepository<DowJonesIndex, Long> {
}
