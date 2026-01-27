package com.example.componets;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DateUtils {
    public LocalDateTime today(){
        return LocalDateTime.now();
    }
}
//use of component