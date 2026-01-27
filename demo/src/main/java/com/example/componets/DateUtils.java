package com.example.componets;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtils {
    public String today(){
        return LocalDate.now().toString();
    }
}
