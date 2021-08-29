package com.lokesh.history.model.day;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@Data
@MappedSuperclass
public class Day {
    @Id
    Date day;
    Double open;
    Double high;
    Double low;
    Double close;
    Long volume;
    Long oi;
}
