package com.lokesh.history.history;

import com.lokesh.history.Constants.Instruments;
import com.lokesh.history.utils.HistoryUtils;
import com.zerodhatech.models.HistoricalData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaveInstrumentHistory {

    @Autowired
    DayHistory dayHistory;
    @Autowired
    SaveDayData saveDayData;
    @Autowired
    HistoryUtils historyUtils;

    public Boolean saveAllInstrument(){
        //TODO: Read the json from the instruments.json file
        List<String> instrumentTokens = new ArrayList<>();
        //instrumentTokens.add("ITC");
        instrumentTokens.add("HDFCBANK");
        for (String instrumentToken : instrumentTokens) {
            saveIntrument(instrumentToken);
        }
        return true;
    }

    private void saveIntrument(String instrumentToken){
        Date previousAvailableDate = historyUtils.getPreviousAvailableDate(Instruments.valueOf(instrumentToken));
        Date today = new Date();

        if(previousAvailableDate.compareTo(today) != 0) {
            HistoricalData historicalData = dayHistory.fetchHistory(instrumentToken);
            try {
                saveDayData.save(Instruments.valueOf(instrumentToken), historicalData);
                saveIntrument(instrumentToken);
            } catch (Exception e) {
                //Not able to create the JPA Repository for the interface.
                e.printStackTrace();

            }
        }
    }
}
