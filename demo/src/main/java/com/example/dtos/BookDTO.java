package com.example.dtos;

import java.util.List;
import lombok.Data;
@Data
public class BookDTO {

    private String title;
    private String isbn;
    private Long libraryId;
    private List<Long> authorsIds;
}
