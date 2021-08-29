package com.lokesh.history.history;

import com.lokesh.history.Constants.Instruments;
import com.lokesh.history.model.day.Day;
import com.lokesh.history.model.day.HDFCBANK;
import com.lokesh.history.repository.day.HDFCBANKRepository;
import com.zerodhatech.models.HistoricalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SaveDayData {
    @Autowired
    HDFCBANKRepository hdfcbankRepository;
    public void save(Instruments instrument, HistoricalData historicalData) {
        switch(instrument){
            case HDFCBANK:
                HDFCBANK hdfcbank = new HDFCBANK();
                setData(hdfcbank,historicalData);
                hdfcbankRepository.save(hdfcbank);
                break;
            case ITC:
                break;
        }
    }

    private void setData(Day day,HistoricalData historicalData){
        day.setDay(new Date(historicalData.timeStamp));
        day.setOpen(historicalData.open);
        day.setLow(historicalData.low);
        day.setHigh(historicalData.high);
        day.setClose(historicalData.close);
        day.setOi(historicalData.oi);
        day.setVolume(historicalData.volume);
    }
}
