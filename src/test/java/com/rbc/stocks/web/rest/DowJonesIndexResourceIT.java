package com.rbc.stocks.web.rest;

import com.rbc.stocks.RbcstocksApp;
import com.rbc.stocks.domain.DowJonesIndex;
import com.rbc.stocks.repository.DowJonesIndexRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DowJonesIndexResource} REST controller.
 */
@SpringBootTest(classes = RbcstocksApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DowJonesIndexResourceIT {

    private static final Integer DEFAULT_QUARTER = 1;
    private static final Integer UPDATED_QUARTER = 2;

    private static final String DEFAULT_STOCK = "AAAAA";
    private static final String UPDATED_STOCK = "BBBBB";

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final BigDecimal DEFAULT_OPEN = new BigDecimal(1);
    private static final BigDecimal UPDATED_OPEN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_HIGH = new BigDecimal(1);
    private static final BigDecimal UPDATED_HIGH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_LOW = new BigDecimal(1);
    private static final BigDecimal UPDATED_LOW = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CLOSE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CLOSE = new BigDecimal(2);

    private static final Integer DEFAULT_VOLUME = 1;
    private static final Integer UPDATED_VOLUME = 2;

    private static final Double DEFAULT_PERCENT_CHANGE_PRICE = 1D;
    private static final Double UPDATED_PERCENT_CHANGE_PRICE = 2D;

    private static final Double DEFAULT_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK = 1D;
    private static final Double UPDATED_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK = 2D;

    private static final Double DEFAULT_PREVIOUS_WEEKS_VOLUME = 1D;
    private static final Double UPDATED_PREVIOUS_WEEKS_VOLUME = 2D;

    private static final BigDecimal DEFAULT_NEXT_WEEKS_OPEN = new BigDecimal(1);
    private static final BigDecimal UPDATED_NEXT_WEEKS_OPEN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NEXT_WEEKS_CLOSE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NEXT_WEEKS_CLOSE = new BigDecimal(2);

    private static final Double DEFAULT_PERCENT_CHANGE_NEXT_WEEKS_PRICE = 1D;
    private static final Double UPDATED_PERCENT_CHANGE_NEXT_WEEKS_PRICE = 2D;

    private static final Integer DEFAULT_DAYS_TO_NEXT_DIVIDEND = 1;
    private static final Integer UPDATED_DAYS_TO_NEXT_DIVIDEND = 2;

    private static final Double DEFAULT_PERCENT_RETURN_NEXT_DIVIDEND = 1D;
    private static final Double UPDATED_PERCENT_RETURN_NEXT_DIVIDEND = 2D;

    @Autowired
    private DowJonesIndexRepository dowJonesIndexRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDowJonesIndexMockMvc;

    private DowJonesIndex dowJonesIndex;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DowJonesIndex createEntity(EntityManager em) {
        DowJonesIndex dowJonesIndex = new DowJonesIndex()
            .quarter(DEFAULT_QUARTER)
            .stock(DEFAULT_STOCK)
            .date(DEFAULT_DATE)
            .open(DEFAULT_OPEN)
            .high(DEFAULT_HIGH)
            .low(DEFAULT_LOW)
            .close(DEFAULT_CLOSE)
            .volume(DEFAULT_VOLUME)
            .percentChangePrice(DEFAULT_PERCENT_CHANGE_PRICE)
            .percentChangeVolumeOverLastWeek(DEFAULT_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK)
            .previousWeeksVolume(DEFAULT_PREVIOUS_WEEKS_VOLUME)
            .nextWeeksOpen(DEFAULT_NEXT_WEEKS_OPEN)
            .nextWeeksClose(DEFAULT_NEXT_WEEKS_CLOSE)
            .percentChangeNextWeeksPrice(DEFAULT_PERCENT_CHANGE_NEXT_WEEKS_PRICE)
            .daysToNextDividend(DEFAULT_DAYS_TO_NEXT_DIVIDEND)
            .percentReturnNextDividend(DEFAULT_PERCENT_RETURN_NEXT_DIVIDEND);
        return dowJonesIndex;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DowJonesIndex createUpdatedEntity(EntityManager em) {
        DowJonesIndex dowJonesIndex = new DowJonesIndex()
            .quarter(UPDATED_QUARTER)
            .stock(UPDATED_STOCK)
            .date(UPDATED_DATE)
            .open(UPDATED_OPEN)
            .high(UPDATED_HIGH)
            .low(UPDATED_LOW)
            .close(UPDATED_CLOSE)
            .volume(UPDATED_VOLUME)
            .percentChangePrice(UPDATED_PERCENT_CHANGE_PRICE)
            .percentChangeVolumeOverLastWeek(UPDATED_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK)
            .previousWeeksVolume(UPDATED_PREVIOUS_WEEKS_VOLUME)
            .nextWeeksOpen(UPDATED_NEXT_WEEKS_OPEN)
            .nextWeeksClose(UPDATED_NEXT_WEEKS_CLOSE)
            .percentChangeNextWeeksPrice(UPDATED_PERCENT_CHANGE_NEXT_WEEKS_PRICE)
            .daysToNextDividend(UPDATED_DAYS_TO_NEXT_DIVIDEND)
            .percentReturnNextDividend(UPDATED_PERCENT_RETURN_NEXT_DIVIDEND);
        return dowJonesIndex;
    }

    @BeforeEach
    public void initTest() {
        dowJonesIndex = createEntity(em);
    }

    @Test
    @Transactional
    public void getAllDowJonesIndices() throws Exception {
        // Initialize the database
        dowJonesIndexRepository.saveAndFlush(dowJonesIndex);

        // Get all the dowJonesIndexList
        restDowJonesIndexMockMvc.perform(get("/api/dow-jones-indices?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dowJonesIndex.getId().intValue())))
            .andExpect(jsonPath("$.[*].quarter").value(hasItem(DEFAULT_QUARTER)))
            .andExpect(jsonPath("$.[*].stock").value(hasItem(DEFAULT_STOCK)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].open").value(hasItem(DEFAULT_OPEN.intValue())))
            .andExpect(jsonPath("$.[*].high").value(hasItem(DEFAULT_HIGH.intValue())))
            .andExpect(jsonPath("$.[*].low").value(hasItem(DEFAULT_LOW.intValue())))
            .andExpect(jsonPath("$.[*].close").value(hasItem(DEFAULT_CLOSE.intValue())))
            .andExpect(jsonPath("$.[*].volume").value(hasItem(DEFAULT_VOLUME)))
            .andExpect(jsonPath("$.[*].percentChangePrice").value(hasItem(DEFAULT_PERCENT_CHANGE_PRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].percentChangeVolumeOverLastWeek").value(hasItem(DEFAULT_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK.doubleValue())))
            .andExpect(jsonPath("$.[*].previousWeeksVolume").value(hasItem(DEFAULT_PREVIOUS_WEEKS_VOLUME.doubleValue())))
            .andExpect(jsonPath("$.[*].nextWeeksOpen").value(hasItem(DEFAULT_NEXT_WEEKS_OPEN.intValue())))
            .andExpect(jsonPath("$.[*].nextWeeksClose").value(hasItem(DEFAULT_NEXT_WEEKS_CLOSE.intValue())))
            .andExpect(jsonPath("$.[*].percentChangeNextWeeksPrice").value(hasItem(DEFAULT_PERCENT_CHANGE_NEXT_WEEKS_PRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].daysToNextDividend").value(hasItem(DEFAULT_DAYS_TO_NEXT_DIVIDEND)))
            .andExpect(jsonPath("$.[*].percentReturnNextDividend").value(hasItem(DEFAULT_PERCENT_RETURN_NEXT_DIVIDEND.doubleValue())));
    }
    
    @Test
    @Transactional
    public void getDowJonesIndex() throws Exception {
        // Initialize the database
        dowJonesIndexRepository.saveAndFlush(dowJonesIndex);

        // Get the dowJonesIndex
        restDowJonesIndexMockMvc.perform(get("/api/dow-jones-indices/{id}", dowJonesIndex.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dowJonesIndex.getId().intValue()))
            .andExpect(jsonPath("$.quarter").value(DEFAULT_QUARTER))
            .andExpect(jsonPath("$.stock").value(DEFAULT_STOCK))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.open").value(DEFAULT_OPEN.intValue()))
            .andExpect(jsonPath("$.high").value(DEFAULT_HIGH.intValue()))
            .andExpect(jsonPath("$.low").value(DEFAULT_LOW.intValue()))
            .andExpect(jsonPath("$.close").value(DEFAULT_CLOSE.intValue()))
            .andExpect(jsonPath("$.volume").value(DEFAULT_VOLUME))
            .andExpect(jsonPath("$.percentChangePrice").value(DEFAULT_PERCENT_CHANGE_PRICE.doubleValue()))
            .andExpect(jsonPath("$.percentChangeVolumeOverLastWeek").value(DEFAULT_PERCENT_CHANGE_VOLUME_OVER_LAST_WEEK.doubleValue()))
            .andExpect(jsonPath("$.previousWeeksVolume").value(DEFAULT_PREVIOUS_WEEKS_VOLUME.doubleValue()))
            .andExpect(jsonPath("$.nextWeeksOpen").value(DEFAULT_NEXT_WEEKS_OPEN.intValue()))
            .andExpect(jsonPath("$.nextWeeksClose").value(DEFAULT_NEXT_WEEKS_CLOSE.intValue()))
            .andExpect(jsonPath("$.percentChangeNextWeeksPrice").value(DEFAULT_PERCENT_CHANGE_NEXT_WEEKS_PRICE.doubleValue()))
            .andExpect(jsonPath("$.daysToNextDividend").value(DEFAULT_DAYS_TO_NEXT_DIVIDEND))
            .andExpect(jsonPath("$.percentReturnNextDividend").value(DEFAULT_PERCENT_RETURN_NEXT_DIVIDEND.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDowJonesIndex() throws Exception {
        // Get the dowJonesIndex
        restDowJonesIndexMockMvc.perform(get("/api/dow-jones-indices/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }
}
