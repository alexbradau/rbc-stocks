package com.rbc.stocks.repository;

import java.util.List;

import com.rbc.stocks.domain.DowJonesIndex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DowJonesIndex entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DowJonesIndexRepository extends JpaRepository<DowJonesIndex, String> {
    @Query("SELECT index FROM DowJonesIndex index WHERE index.stock = ?1")
    List<DowJonesIndex> findByStock(String stock);
}
