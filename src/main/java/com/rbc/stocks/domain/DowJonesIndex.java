package com.rbc.stocks.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A DowJonesIndex.
 */
@Entity
@Table(name = "dow_jones_index")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DowJonesIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 4)
    @Column(name = "quarter", nullable = false)
    private Integer quarter;

    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "stock", length = 5, nullable = false)
    private String stock;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "open", precision = 21, scale = 2, nullable = false)
    private BigDecimal open;

    @NotNull
    @Column(name = "high", precision = 21, scale = 2, nullable = false)
    private BigDecimal high;

    @NotNull
    @Column(name = "low", precision = 21, scale = 2, nullable = false)
    private BigDecimal low;

    @NotNull
    @Column(name = "close", precision = 21, scale = 2, nullable = false)
    private BigDecimal close;

    @NotNull
    @Column(name = "volume", nullable = false)
    private Integer volume;

    @NotNull
    @Column(name = "percent_change_price", nullable = false)
    private Double percentChangePrice;

    @Column(name = "percent_change_volume_over_last_week")
    private Double percentChangeVolumeOverLastWeek;

    @Column(name = "previous_weeks_volume")
    private Double previousWeeksVolume;

    @Column(name = "next_weeks_open", precision = 21, scale = 2)
    private BigDecimal nextWeeksOpen;

    @Column(name = "next_weeks_close", precision = 21, scale = 2)
    private BigDecimal nextWeeksClose;

    @Column(name = "percent_change_next_weeks_price")
    private Double percentChangeNextWeeksPrice;

    @Column(name = "days_to_next_dividend")
    private Integer daysToNextDividend;

    @Column(name = "percent_return_next_dividend")
    private Double percentReturnNextDividend;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public DowJonesIndex quarter(Integer quarter) {
        this.quarter = quarter;
        return this;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return stock;
    }

    public DowJonesIndex stock(String stock) {
        this.stock = stock;
        return this;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public LocalDate getDate() {
        return date;
    }

    public DowJonesIndex date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public DowJonesIndex open(BigDecimal open) {
        this.open = open;
        return this;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public DowJonesIndex high(BigDecimal high) {
        this.high = high;
        return this;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public DowJonesIndex low(BigDecimal low) {
        this.low = low;
        return this;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public DowJonesIndex close(BigDecimal close) {
        this.close = close;
        return this;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    public DowJonesIndex volume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPercentChangePrice() {
        return percentChangePrice;
    }

    public DowJonesIndex percentChangePrice(Double percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
        return this;
    }

    public void setPercentChangePrice(Double percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
    }

    public Double getPercentChangeVolumeOverLastWeek() {
        return percentChangeVolumeOverLastWeek;
    }

    public DowJonesIndex percentChangeVolumeOverLastWeek(Double percentChangeVolumeOverLastWeek) {
        this.percentChangeVolumeOverLastWeek = percentChangeVolumeOverLastWeek;
        return this;
    }

    public void setPercentChangeVolumeOverLastWeek(Double percentChangeVolumeOverLastWeek) {
        this.percentChangeVolumeOverLastWeek = percentChangeVolumeOverLastWeek;
    }

    public Double getPreviousWeeksVolume() {
        return previousWeeksVolume;
    }

    public DowJonesIndex previousWeeksVolume(Double previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
        return this;
    }

    public void setPreviousWeeksVolume(Double previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
    }

    public BigDecimal getNextWeeksOpen() {
        return nextWeeksOpen;
    }

    public DowJonesIndex nextWeeksOpen(BigDecimal nextWeeksOpen) {
        this.nextWeeksOpen = nextWeeksOpen;
        return this;
    }

    public void setNextWeeksOpen(BigDecimal nextWeeksOpen) {
        this.nextWeeksOpen = nextWeeksOpen;
    }

    public BigDecimal getNextWeeksClose() {
        return nextWeeksClose;
    }

    public DowJonesIndex nextWeeksClose(BigDecimal nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
        return this;
    }

    public void setNextWeeksClose(BigDecimal nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
    }

    public Double getPercentChangeNextWeeksPrice() {
        return percentChangeNextWeeksPrice;
    }

    public DowJonesIndex percentChangeNextWeeksPrice(Double percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
        return this;
    }

    public void setPercentChangeNextWeeksPrice(Double percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    }

    public Integer getDaysToNextDividend() {
        return daysToNextDividend;
    }

    public DowJonesIndex daysToNextDividend(Integer daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
        return this;
    }

    public void setDaysToNextDividend(Integer daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
    }

    public Double getPercentReturnNextDividend() {
        return percentReturnNextDividend;
    }

    public DowJonesIndex percentReturnNextDividend(Double percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
        return this;
    }

    public void setPercentReturnNextDividend(Double percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DowJonesIndex)) {
            return false;
        }
        return id != null && id.equals(((DowJonesIndex) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DowJonesIndex{" +
            "id=" + getId() +
            ", quarter=" + getQuarter() +
            ", stock='" + getStock() + "'" +
            ", date='" + getDate() + "'" +
            ", open=" + getOpen() +
            ", high=" + getHigh() +
            ", low=" + getLow() +
            ", close=" + getClose() +
            ", volume=" + getVolume() +
            ", percentChangePrice=" + getPercentChangePrice() +
            ", percentChangeVolumeOverLastWeek=" + getPercentChangeVolumeOverLastWeek() +
            ", previousWeeksVolume=" + getPreviousWeeksVolume() +
            ", nextWeeksOpen=" + getNextWeeksOpen() +
            ", nextWeeksClose=" + getNextWeeksClose() +
            ", percentChangeNextWeeksPrice=" + getPercentChangeNextWeeksPrice() +
            ", daysToNextDividend=" + getDaysToNextDividend() +
            ", percentReturnNextDividend=" + getPercentReturnNextDividend() +
            "}";
    }
}
