package com.rbc.stocks.web.rest;

import java.net.URISyntaxException;
import java.util.List;

import com.rbc.stocks.domain.DowJonesIndex;
import com.rbc.stocks.repository.DowJonesIndexRepository;
import com.rbc.stocks.service.DowJonesIndexService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/dow-jones-indices")
    public List<DowJonesIndex> getAllDowJonesIndices() {
        log.debug("REST request to get a page of DowJonesIndices");
        return dowJonesIndexRepository.findAll();
    }

    @GetMapping("/dow-jones-indices/{stock}")
    public List<DowJonesIndex> getDowJonesIndexByStock(@PathVariable String stock) {
        log.debug("REST request to get DowJonesIndex : {}", stock);
        List<DowJonesIndex> dowJonesIndex = dowJonesIndexRepository.findByStock(stock);
        return dowJonesIndex;
    }

    @PostMapping("/dow-jones-indices")
    public DowJonesIndex createDowJonesIndex(@RequestBody DowJonesIndex index) throws URISyntaxException {
        
        return djiService.createNewIndex(index);
        
    }

    @PostMapping("/upload-file")
    public List<DowJonesIndex> uploadFile(@RequestParam("file") MultipartFile file) {
        return djiService.saveDowJonesIndexBulkData(file);
    }
}
