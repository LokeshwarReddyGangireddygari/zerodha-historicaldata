package com.lokesh.history.controller;

import com.lokesh.history.history.SaveInstrumentHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Day {
    @Autowired
    SaveInstrumentHistory saveInstrumentHistory;
    @PostMapping("/instruments")
    public void saveDayHistory(){
        saveInstrumentHistory.saveAllInstrument();
    }
}
