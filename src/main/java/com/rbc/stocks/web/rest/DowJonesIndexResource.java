package com.rbc.stocks.web.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.rbc.stocks.domain.DowJonesIndex;
import com.rbc.stocks.repository.DowJonesIndexRepository;
import com.rbc.stocks.service.DowJonesIndexService;
import com.rbc.stocks.web.rest.errors.BadRequestAlertException;
import com.rbc.stocks.web.rest.errors.LoginAlreadyUsedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.rbc.stocks.domain.DowJonesIndex}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DowJonesIndexResource {

    private final Logger log = LoggerFactory.getLogger(DowJonesIndexResource.class);

    private final DowJonesIndexRepository dowJonesIndexRepository;

    @Autowired
    private DowJonesIndexService djiService;

    public DowJonesIndexResource(DowJonesIndexRepository dowJonesIndexRepository) {
        this.dowJonesIndexRepository = dowJonesIndexRepository;
    }

    /**
     * {@code GET  /dow-jones-indices} : get all the dowJonesIndices.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dowJonesIndices in body.
     */
    @GetMapping("/dow-jones-indices")
    public ResponseEntity<List<DowJonesIndex>> getAllDowJonesIndices(Pageable pageable) {
        log.debug("REST request to get a page of DowJonesIndices");
        Page<DowJonesIndex> page = dowJonesIndexRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/dow-jones-indices-stock/{stock}")
    public List<DowJonesIndex> getDowJonesIndexByStock(@PathVariable String stock) {
        log.debug("REST request to get DowJonesIndex : {}", stock);
        List<DowJonesIndex> dowJonesIndex = dowJonesIndexRepository.findByStock(stock);
        return dowJonesIndex;
    }

    @RequestMapping("/uploadBulkData")
    public void saveBulkData(){
        djiService.saveDowJonesIndexBulkData();
    }
}
