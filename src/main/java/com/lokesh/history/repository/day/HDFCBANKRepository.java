package com.lokesh.history.repository.day;

import com.lokesh.history.model.day.HDFCBANK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface HDFCBANKRepository extends CrudRepository<HDFCBANK, Date> {
    @Query("SELECT MAX(day) FROM HDFCBANK")
    Date getLatestAvailalbleDay();
}
