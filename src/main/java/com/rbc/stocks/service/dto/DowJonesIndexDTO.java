package com.rbc.stocks.service.dto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbc.stocks.domain.DowJonesIndex;

@Repository
public interface DowJonesIndexDTO extends CrudRepository<DowJonesIndex, Long>{




}