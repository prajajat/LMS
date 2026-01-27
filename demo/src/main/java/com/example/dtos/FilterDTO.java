package com.example.dtos;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FilterDTO {
    private String title;
    private String author;
    private Boolean  isAvailable;
}