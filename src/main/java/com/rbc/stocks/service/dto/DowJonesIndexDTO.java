package com.rbc.stocks.service.dto;

import com.rbc.stocks.domain.DowJonesIndex;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DowJonesIndexDTO extends CrudRepository<DowJonesIndex, Long>{
}