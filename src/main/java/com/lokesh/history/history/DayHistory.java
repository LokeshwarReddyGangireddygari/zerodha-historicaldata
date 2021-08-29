package com.lokesh.history.history;

import com.lokesh.history.Constants.Instruments;
import com.lokesh.history.Temp;
import com.lokesh.history.config.Config;
import com.lokesh.history.utils.DateUtils;
import com.lokesh.history.utils.HistoryUtils;
import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.HistoricalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
@Component
public class DayHistory {
    @Autowired
    HistoryUtils historyUtils;
    @Autowired
    Config config;
    public HistoricalData fetchHistory(String instrumentToken){
        HistoricalData historicalData;
        final String interval = "day";
        //Fetch the data for 1 day.
        Date previousAvailableDate = historyUtils.getPreviousAvailableDate(Instruments.valueOf(instrumentToken));
        Date nextDate;
        if(previousAvailableDate != null){
            nextDate = DateUtils.findNextDay(previousAvailableDate);
        }else{
            nextDate = config.getAvailableHistoricalDataFrom();
        }

        boolean continuousData = true;
        boolean oi = true;
        historicalData = new HistoricalData();
        historicalData.timeStamp=nextDate.toString();
        historicalData.oi=2500;
        historicalData.volume=3000;
        historicalData.low=200;
        historicalData.high=500;
        historicalData.close=400;
       /* if(nextDate !=  null && nextDate !=null && instrumentToken !=null){
            try {
               historicalData = Temp.kitesdk.getHistoricalData(nextDate,nextDate,instrumentToken,interval,continuousData,oi);

                return historicalData;
            } catch (KiteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return historicalData;
    }

}
