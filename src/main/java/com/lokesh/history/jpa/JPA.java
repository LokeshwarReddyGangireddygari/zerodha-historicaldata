package com.lokesh.history.jpa;

import com.lokesh.history.model.day.Day;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;
@Data
public class JPA {
    CrudRepository crudRepository;
    Day day;
}
