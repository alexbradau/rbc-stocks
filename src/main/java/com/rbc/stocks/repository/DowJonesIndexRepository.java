package com.rbc.stocks.repository;

import com.rbc.stocks.domain.DowJonesIndex;
import com.rbc.stocks.web.rest.DowJonesIndexResource;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the DowJonesIndex entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DowJonesIndexRepository extends JpaRepository<DowJonesIndex, String> {
    @Query("SELECT index FROM DowJonesIndex index WHERE index.stock = ?1")
    Optional<DowJonesIndex> findByStock(String stock);
}
