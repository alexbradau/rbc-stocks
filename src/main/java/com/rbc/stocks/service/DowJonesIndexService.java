package com.rbc.stocks.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.rbc.stocks.domain.DowJonesIndex;
import com.rbc.stocks.service.dto.DowJonesIndexDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DowJonesIndexService {

    private final Logger log = LoggerFactory.getLogger(DowJonesIndexService.class);

    @Autowired
    private DowJonesIndexDTO djiDTO;

    public void saveDowJonesIndexBulkData(){
        String line = "";
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("files/dow_jones_index.data"));
            br.readLine();
            while((line=br.readLine()) != null){
                line = line.replaceAll("[\\$]", "");
                djiDTO.save(parseRecord(line));
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }

    private DowJonesIndex parseRecord(String record){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        String [] data = record.split(",");
        DowJonesIndex dowJonesIndex = new DowJonesIndex();
        dowJonesIndex.setQuarter(Integer.parseInt(data[0]));
        dowJonesIndex.setStock(data[1]);
        dowJonesIndex.setDate(LocalDate.parse(data[2], dtf));
        dowJonesIndex.setOpen(new BigDecimal(data[3]));
        dowJonesIndex.setHigh(new BigDecimal(data[4]));
        dowJonesIndex.setLow(new BigDecimal(data[5]));
        dowJonesIndex.setClose(new BigDecimal(data[6]));
        dowJonesIndex.setVolume(Integer.parseInt(data[7]));
        dowJonesIndex.setPercentChangePrice(Double.parseDouble(data[8]));
        dowJonesIndex.setPercentChangeVolumeOverLastWeek(!data[9].isBlank() ? Double.parseDouble(data[9]) : null);
        dowJonesIndex.setPreviousWeeksVolume(!data[10].isBlank() ? Double.parseDouble(data[10]) : null);
        dowJonesIndex.setNextWeeksOpen(new BigDecimal(data[11]));
        dowJonesIndex.setNextWeeksClose(new BigDecimal(data[12]));
        dowJonesIndex.setPercentChangeNextWeeksPrice(Double.parseDouble(data[13]));
        dowJonesIndex.setDaysToNextDividend(Integer.parseInt(data[14]));
        dowJonesIndex.setPercentReturnNextDividend(Double.parseDouble(data[15]));
        return dowJonesIndex;
    }

}
