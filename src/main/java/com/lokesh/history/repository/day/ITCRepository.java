package com.lokesh.history.repository.day;

import com.lokesh.history.model.day.ITC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface ITCRepository extends CrudRepository<ITC, Date> {
    @Query("SELECT MAX(day) FROM ITC")
    Date getLatestAvailalbleDay();

}