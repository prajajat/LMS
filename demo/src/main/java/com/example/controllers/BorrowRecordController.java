package com.example.controllers;

import com.example.dtos.BookDTO;
import com.example.dtos.BorrowDTO;
import com.example.entites.Book;
import com.example.entites.BorrowRecord;
import com.example.services.BookService;
import com.example.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowRecordController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/create")
    public ResponseEntity<BorrowRecord> createBorrowRecord(@RequestBody BorrowDTO dto) {
        BorrowRecord b= borrowService.createBorrow(dto);
        return ResponseEntity.ok(b);
    }
}
