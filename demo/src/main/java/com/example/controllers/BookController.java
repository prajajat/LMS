package com.example.controllers;

import com.example.dtos.BookDTO;
import com.example.dtos.FilterDTO;
import com.example.entites.Book;
import com.example.services.BookService;
//import org.springdoc.api.annotations.ParameterObject;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<Page<Book>> getBooks(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "title") String sortBy,
                                                @RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok(bookService.getAllBooks(page, size, sortBy, direction));
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Book> getBook(@PathVariable Long Id) {
        return ResponseEntity.ok(bookService.getBook(Id));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Book>> getFilteredBook(@PathVariable FilterDTO filterDTO) {
        return ResponseEntity.ok(bookService.getFilteredBook(filterDTO));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody BookDTO dto) {
        bookService.createBook(dto);
        return ResponseEntity.ok().build();
    }


}
