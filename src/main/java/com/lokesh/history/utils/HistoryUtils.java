package com.lokesh.history.utils;

import com.lokesh.history.Constants.Instruments;
import com.lokesh.history.model.day.Day;
import com.lokesh.history.model.day.HDFCBANK;
import com.lokesh.history.repository.day.HDFCBANKRepository;
import com.lokesh.history.repository.day.ITCRepository;
import com.zerodhatech.models.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Component
public class HistoryUtils {
    @Autowired
    HDFCBANKRepository hdfcbankRepository;
    @Autowired
    ITCRepository itcRepository;
    Day day;
    public  Date getPreviousAvailableDate(Instruments instrument){
        switch(instrument) {
            case HDFCBANK:
                return hdfcbankRepository.getLatestAvailalbleDay();

            case ITC:
               return  itcRepository.getLatestAvailalbleDay();

            default:
                throw new IllegalStateException("Unexpected value: " + instrument);
        }

    }
}
