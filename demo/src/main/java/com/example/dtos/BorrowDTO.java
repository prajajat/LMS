package com.example.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class BorrowDTO {


    private Long bookId;
    private Long libraryId;
    private Long memberId;
    private LocalDateTime returnDate;

}
